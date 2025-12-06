package Sorting;

public class TimSort {

    /*Tim Sort is a hybrid sorting algorithm derived from Merge Sort and Insertion Sort. 
    It is designed to perform well on many kinds of real-world data. 
    The algorithm divides the array into small segments called "runs" and sorts each run using Insertion Sort. 
    Then, it merges the sorted runs using a process similar to Merge Sort.
        1. Divide the array into runs of a minimum size (typically 32 or 64).
        2. Sort each run using Insertion Sort.
        3. Merge the sorted runs using a merging technique similar to Merge Sort.
    Time Complexity: O(n log n)*/

    private static final int RUN = 32;

    public static void sort(int[] arr) {
        int n = arr.length;

        for (int start = 0; start < n; start += RUN) {
            int end = Math.min(start + RUN - 1, n - 1);
            insertionSort(arr, start, end);
        }

        for (int size = RUN; size < n; size *= 2) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = Math.min(left + size - 1, n - 1);
                int right = Math.min((left + 2 * size - 1), (n - 1));

                if (mid < right) {
                    merge(arr, left, mid, right);
                }
            }
        }
    }

    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

   private static void merge(int[] arr, int left, int mid, int right) {
        int len1 = mid - left + 1;
        int len2 = right - mid;

        int[] leftArr = new int[len1];
        int[] rightArr = new int[len2];

        System.arraycopy(arr, left, leftArr, 0, len1);
        System.arraycopy(arr, mid + 1, rightArr, 0, len2);

        int i = 0, j = 0, k = left;

        while (i < len1 && j < len2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < len1) arr[k++] = leftArr[i++];
        while (j < len2) arr[k++] = rightArr[j++];
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 9, 1, 7};
        TimSort.sort(a);
        for (int x : a) System.out.print(x + " ");
    }
}