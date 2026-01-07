/*Table: Products
+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| product_id    | int     |
| new_price     | int     |
| change_date   | date    |
+---------------+---------+
(product_id, change_date) is the primary key (combination of columns with unique values) of this table.
Each row of this table indicates that the price of some product was changed to a new price at some date.
Initially, all products have price 10.
Write a solution to find the prices of all products on the date 2019-08-16.*/

SELECT
    product_id,
    10 AS price
FROM Products
GROUP BY product_id
HAVING MIN(change_date) > '2019-08-16'

UNION ALL

SELECT
    p.product_id,
    p.new_price AS price
FROM Products p
JOIN (
    SELECT product_id, MAX(change_date) AS max_date
    FROM Products
    WHERE change_date <= '2019-08-16'
    GROUP BY product_id
) t
ON p.product_id = t.product_id AND p.change_date = t.max_date;
