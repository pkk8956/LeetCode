package Sorting;

public class ShellSort {

    /*Shell Sort is an optimization of Insertion Sort that allows the exchange of items that are far apart. 
    The idea is to arrange the list of elements so that, starting anywhere, taking every hth element produces a sorted list. 
    Such a list is said to be h-sorted. The algorithm uses a sequence of gaps (h values) to sort the array.
        1. Start with a large gap and reduce the gap until it becomes 1.
        2. For each gap, perform a gapped insertion sort.
    Time Complexity: O(n log n) to O(n^2) depending on the gap sequence used.*/

    public static void sort(int[] arr) {
        int n = arr.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 9, 1, 7};
        sort(a);
        for (int x : a) System.out.print(x + " ");
    }
    
}
