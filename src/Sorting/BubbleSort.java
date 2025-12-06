package Sorting;

public class BubbleSort {

    /*Bubble Sort is a simple comparison-based sorting algorithm. It works by repeatedly stepping through the list to be sorted, 
    comparing adjacent elements and swapping them if they are in the wrong order. 
    The pass through the list is repeated until the list is sorted.
        1. We start at the beginning of the array and compare the first two elements.
        2. If the first element is greater than the second, we swap them.
        3. We move to the next pair of adjacent elements and repeat the process until we reach the end of the array.
        4. This process is repeated for the entire array until no swaps are needed, indicating that the array is sorted.
    Time Complexity: O(n2)*/

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
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
