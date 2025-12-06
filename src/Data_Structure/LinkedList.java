package Data_Structure;

class LinkedList<T> {
    private static class Node<T> {
        T value;
        Node<T> next;
        Node(T value) { this.value = value; }
    }

    private Node<T> head;
    private int size;

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) current = current.next;
            current.next = newNode;
        }
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index);
        Node<T> current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current.value;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index);
        if (index == 0) {
            T value = head.value;
            head = head.next;
            size--;
            return value;
        }
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) current = current.next;
        T value = current.next.value;
        current.next = current.next.next;
        size--;
        return value;
    }

    public int size() {
        return size;
    }
}
