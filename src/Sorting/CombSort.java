package Sorting;

public class CombSort {

    /*Comb Sort is an improved version of Bubble Sort that eliminates small values near the end of the list, 
    which slows down the sorting process. It works by comparing elements at a certain gap and reducing the gap over time.
        1. Start with a large gap and reduce it gradually to 1.
        2. Compare elements at the current gap and swap them if they are out of order.
        3. Repeat the process until the gap is 1 and no swaps are needed.
    Time Complexity: O(n log n) on average*/

    public static void sort(int[] arr) {
        int n = arr.length;
        int gap = n;
        boolean swapped = true;
        double shrink = 1.3;

        while (gap > 1 || swapped) {
            if (gap > 1) {
                gap = (int)(gap / shrink);
            }

            swapped = false;

            for (int i = 0; i + gap < n; i++) {
                if (arr[i] > arr[i + gap]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = tmp;
                    swapped = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 9, 1, 7};
        sort(a);
        for (int x : a) System.out.print(x + " ");
    }
    
}
