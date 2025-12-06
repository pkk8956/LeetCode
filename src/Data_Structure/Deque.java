package Data_Structure;

public class Deque<T> {
    private Object[] data;
    private int head;
    private int tail;
    private int size;

    public Deque() {
        data = new Object[10];
        head = 0;
        tail = 0;
        size = 0;
    }

    public void addFirst(T value) {
        ensure(size + 1);
        head = (head - 1 + data.length) % data.length;
        data[head] = value;
        size++;
    }

    public void addLast(T value) {
        ensure(size + 1);
        data[tail] = value;
        tail = (tail + 1) % data.length;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T removeFirst() {
        if (size == 0) throw new RuntimeException("Deque is empty");
        T value = (T) data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        size--;
        return value;
    }

    @SuppressWarnings("unchecked")
    public T removeLast() {
        if (size == 0) throw new RuntimeException("Deque is empty");
        tail = (tail - 1 + data.length) % data.length;
        T value = (T) data[tail];
        data[tail] = null;
        size--;
        return value;
    }

    @SuppressWarnings("unchecked")
    public T peekFirst() {
        if (size == 0) throw new RuntimeException("Deque is empty");
        return (T) data[head];
    }

    @SuppressWarnings("unchecked")
    public T peekLast() {
        if (size == 0) throw new RuntimeException("Deque is empty");
        return (T) data[(tail - 1 + data.length) % data.length];
    }

    public int size() {
        return size;
    }

    private void ensure(int needed) {
        if (needed > data.length) {
            Object[] newData = new Object[data.length * 2];
            for (int i = 0; i < size; i++) {
                newData[i] = data[(head + i) % data.length];
            }
            data = newData;
            head = 0;
            tail = size;
        }
    }
}
