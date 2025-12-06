package Data_Structure;

public class HashMap<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry<K, V>[] table;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public HashMap() {
        capacity = 16;
        table = (Entry<K, V>[]) new Entry[capacity];
        size = 0;
    }

    public V put(K key, V value) {
        int index = index(key);
        Entry<K, V> current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                V old = current.value;
                current.value = value;
                return old;
            }
            current = current.next;
        }

        Entry<K, V> newEntry = new Entry<>(key, value);
        newEntry.next = table[index];
        table[index] = newEntry;
        size++;

        if (size > capacity * 0.75) resize();

        return null;
    }

    public V get(K key) {
        int index = index(key);
        Entry<K, V> current = table[index];

        while (current != null) {
            if (current.key.equals(key)) return current.value;
            current = current.next;
        }

        return null;
    }

    public V remove(K key) {
        int index = index(key);
        Entry<K, V> current = table[index];
        Entry<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) table[index] = current.next;
                else prev.next = current.next;
                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }

        return null;
    }

    public int size() {
        return size;
    }

    private int index(K key) {
        return (key == null ? 0 : key.hashCode() & 0x7fffffff) % capacity;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        capacity *= 2;
        Entry<K, V>[] newTable = (Entry<K, V>[]) new Entry[capacity];

        for (Entry<K, V> entry : table) {
            while (entry != null) {
                Entry<K, V> next = entry.next;
                int index = (entry.key == null ? 0 : entry.key.hashCode() & 0x7fffffff) % capacity;
                entry.next = newTable[index];
                newTable[index] = entry;
                entry = next;
            }
        }

        table = newTable;
    }
}
