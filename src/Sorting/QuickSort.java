package Sorting;

public class QuickSort {

    /*Quick Sort is a highly efficient sorting algorithm that follows the divide-and-conquer paradigm. 
    It works by selecting a 'pivot' element from the array and partitioning the other elements into two sub-arrays 
    according to whether they are less than or greater than the pivot. 
    The sub-arrays are then sorted recursively.
        1. Choose a pivot element from the array.
        2. Partition the array into two sub-arrays: elements less than the pivot and elements greater than the pivot.
        3. Recursively apply the above steps to the sub-arrays.
        4. Combine the sorted sub-arrays and the pivot to get the final sorted array.
    Time Complexity: O(n log n) on average, O(n2) in the worst case*/

    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        int tmp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = tmp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 9, 1, 7};
        sort(a, 0, a.length - 1);
        for (int x : a) System.out.print(x + " ");
    }
}