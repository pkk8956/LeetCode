package Data_Structure;

public class Stack<T> {
    private Object[] data;
    private int size;

    public Stack() {
        data = new Object[10];
        size = 0;
    }

    public void push(T value) {
        ensure(size + 1);
        data[size++] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (size == 0) throw new RuntimeException("Stack is empty");
        T value = (T) data[--size];
        data[size] = null;
        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (size == 0) throw new RuntimeException("Stack is empty");
        return (T) data[size - 1];
    }

    public int size() {
        return size;
    }

    private void ensure(int needed) {
        if (needed > data.length) {
            Object[] newData = new Object[data.length * 2];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }
}
