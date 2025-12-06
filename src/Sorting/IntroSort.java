package Sorting;

public class IntroSort {

    /*Intro Sort is a hybrid sorting algorithm that begins with Quick Sort and switches to Heap Sort when the recursion depth exceeds a level based on the number of elements being sorted. 
    This approach helps to avoid the worst-case performance of Quick Sort while maintaining its average-case efficiency.
        1. Start with Quick Sort.
        2. Monitor the recursion depth.
        3. If the depth exceeds a certain limit (usually 2*log(n)), switch to Heap Sort for the remaining elements.
    Time Complexity: O(n log n) in the average and worst cases.*/

    public static void sort(int[] arr) {
        int maxDepth = (int) (2 * Math.log(arr.length) / Math.log(2));
        introSort(arr, 0, arr.length - 1, maxDepth);
    }

    private static void introSort(int[] arr, int start, int end, int depthLimit) {
        if (end - start <= 16) {
            insertionSort(arr, start, end);
            return;
        }
        if (depthLimit == 0) {
            heapSort(arr, start, end);
            return;
        }
        int pivot = partition(arr, start, end);
        introSort(arr, start, pivot - 1, depthLimit - 1);
        introSort(arr, pivot + 1, end, depthLimit - 1);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;
        return i + 1;
    }

    private static void heapSort(int[] arr, int start, int end) {
        int n = end - start + 1;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i, start);
        }

        for (int i = n - 1; i > 0; i--) {
            int t = arr[start];
            arr[start] = arr[start + i];
            arr[start + i] = t;
            heapify(arr, i, 0, start);
        }
    }

    private static void heapify(int[] arr, int size, int i, int start) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && arr[start + left] > arr[start + largest]) largest = left;
        if (right < size && arr[start + right] > arr[start + largest]) largest = right;

        if (largest != i) {
            int t = arr[start + i];
            arr[start + i] = arr[start + largest];
            arr[start + largest] = t;
            heapify(arr, size, largest, start);
        }
    }

    private static void insertionSort(int[] arr, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= start && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 3, 9, 1, 4, 7, 2};
        IntroSort.sort(a);
        for (int x : a) System.out.print(x + " ");
    }
}
