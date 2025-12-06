package Data_Structure;

public class DynamicArray<T> {
    private Object[] data;
    private int size;

    public DynamicArray() {
        this(10);
    }

    public DynamicArray(int initialCapacity) {
        data = new Object[Math.max(1, initialCapacity)];
        size = 0;
    }

    public void add(T value) {
        ensureCapacity(size + 1);
        data[size++] = value;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index);
        return (T) data[index];
    }

    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index);
        T value = (T) data[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) System.arraycopy(data, index + 1, data, index, numMoved);
        data[--size] = null;
        return value;
    }

    public int size() {
        return size;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = data.length * 2;
            if (newCapacity < minCapacity) newCapacity = minCapacity;
            Object[] newData = new Object[newCapacity];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            if (i > 0) sb.append(", ");
            sb.append(String.valueOf(data[i]));
        }
        sb.append(']');
        return sb.toString();
    }
}
