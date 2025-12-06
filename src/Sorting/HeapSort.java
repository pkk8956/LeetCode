package Sorting;

public class HeapSort {

    /*Heap Sort is a comparison-based sorting algorithm that uses a binary heap data structure to sort elements. 
    It works by first building a max heap from the input data, and then repeatedly extracting the maximum element from the heap 
    and rebuilding the heap until all elements are sorted.
        1. Build a max heap from the input array.
        2. The largest element (the root of the heap) is swapped with the last element of the heap.
        3. The size of the heap is reduced by one, and the heap property is restored by calling the heapify function on the root.
        4. This process is repeated until all elements are sorted.
    Time Complexity: O(n log n)*/

    public static void sort(int[] arr) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;

            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 9, 1, 7};
        sort(a);
        for (int x : a) System.out.print(x + " ");
    }
    
}
