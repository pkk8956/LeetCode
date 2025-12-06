package Data_Structure;

public class MaxHeap {
    private int[] heap;
    private int size;

    public MaxHeap() {
        heap = new int[10];
        size = 0;
    }

    public void add(int value) {
        ensure(size + 1);
        heap[size] = value;
        siftUp(size);
        size++;
    }

    public int poll() {
        if (size == 0) throw new RuntimeException("Heap is empty");
        int max = heap[0];
        heap[0] = heap[--size];
        heap[size] = 0;
        siftDown(0);
        return max;
    }

    public int peek() {
        if (size == 0) throw new RuntimeException("Heap is empty");
        return heap[0];
    }

    public int size() {
        return size;
    }

    private void siftUp(int index) {
        int value = heap[index];
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap[parent] >= value) break;
            heap[index] = heap[parent];
            index = parent;
        }
        heap[index] = value;
    }

    private void siftDown(int index) {
        int value = heap[index];
        int half = size / 2;
        while (index < half) {
            int left = 2 * index + 1;
            int right = left + 1;
            int largest = left;
            if (right < size && heap[right] > heap[left]) largest = right;
            if (heap[largest] <= value) break;
            heap[index] = heap[largest];
            index = largest;
        }
        heap[index] = value;
    }

    private void ensure(int needed) {
        if (needed > heap.length) {
            int[] newHeap = new int[heap.length * 2];
            System.arraycopy(heap, 0, newHeap, 0, size);
            heap = newHeap;
        }
    }
}

