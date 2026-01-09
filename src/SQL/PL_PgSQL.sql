-- Accounts table
CREATE TABLE accounts (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    balance NUMERIC(12,2) NOT NULL DEFAULT 0,
    currency CHAR(3) NOT NULL DEFAULT 'USD',
    created_at TIMESTAMP DEFAULT NOW()
);

-- Transactions table
CREATE TABLE transactions (
    id SERIAL PRIMARY KEY,
    from_account INT,
    to_account INT,
    amount NUMERIC(12,2),
    currency CHAR(3),
    created_at TIMESTAMP DEFAULT NOW()
);

-- Audit log table
CREATE TABLE audit_log (
    id SERIAL PRIMARY KEY,
    action TEXT,
    details JSONB,
    created_at TIMESTAMP DEFAULT NOW()
);

-- ===============================================
-- Check if transfer is allowed
-- Returns BOOLEAN
-- ===============================================

CREATE OR REPLACE FUNCTION can_transfer(
    p_from INT,
    p_to INT,
    p_amount NUMERIC
)
RETURNS BOOLEAN
LANGUAGE plpgsql
AS $$
DECLARE
    v_balance NUMERIC;
BEGIN
    -- Get the balance of the sender account
    SELECT balance INTO v_balance
    FROM accounts
    WHERE id = p_from;

    -- If the sender account does not exist, raise an exception
    IF v_balance IS NULL THEN
        RAISE EXCEPTION 'Account % does not exist', p_from;
    END IF;

    -- Check if the balance is sufficient
    IF v_balance < p_amount THEN
        RETURN FALSE;
    END IF;

    -- Maximum allowed transfer amount (business rule)
    IF p_amount > 10000 THEN
        RETURN FALSE;
    END IF;

    -- Transfer is allowed
    RETURN TRUE;
END;
$$;

-- ===============================================
-- Procedure: Perform transfer
-- Uses transactions and writes audit logs
-- ===============================================

CREATE OR REPLACE PROCEDURE transfer_money(
    p_from INT,
    p_to INT,
    p_amount NUMERIC
)
LANGUAGE plpgsql
AS $$
BEGIN
    -- Check transfer validity using the function
    IF NOT can_transfer(p_from, p_to, p_amount) THEN
        RAISE EXCEPTION 'Transfer not allowed';
    END IF;

    -- Deduct amount from sender
    UPDATE accounts
    SET balance = balance - p_amount
    WHERE id = p_from;

    -- Add amount to recipient
    UPDATE accounts
    SET balance = balance + p_amount
    WHERE id = p_to;

    -- Record the transaction
    INSERT INTO transactions(from_account, to_account, amount, currency)
    SELECT p_from, p_to, p_amount, currency FROM accounts WHERE id = p_from;

    -- Insert audit log
    INSERT INTO audit_log(action, details)
    VALUES ('TRANSFER', jsonb_build_object(
        'from', p_from,
        'to', p_to,
        'amount', p_amount,
        'time', NOW()
    ));

    -- Commit changes
    COMMIT;

EXCEPTION
    WHEN OTHERS THEN
        -- Rollback on any error
        ROLLBACK;
        RAISE;
END;
$$;

-- ===============================================
-- Trigger Function: Log balance changes
-- ===============================================

CREATE OR REPLACE FUNCTION log_balance_change()
RETURNS TRIGGER
LANGUAGE plpgsql
AS $$
BEGIN
    -- Insert an audit record whenever balance changes
    INSERT INTO audit_log(action, details)
    VALUES (
        'BALANCE_CHANGE',
        jsonb_build_object(
            'account', NEW.id,
            'old_balance', OLD.balance,
            'new_balance', NEW.balance,
            'time', NOW()
        )
    );

    -- Return the new row (required for AFTER UPDATE triggers)
    RETURN NEW;
END;
$$;

-- ===============================================
-- Trigger: Execute after balance update
-- ===============================================

CREATE TRIGGER trg_balance_change
AFTER UPDATE OF balance ON accounts
FOR EACH ROW
EXECUTE FUNCTION log_balance_change();