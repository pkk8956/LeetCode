package Sorting;

public class SelectionSort {

    /*Selection Sort is a comparison-based sorting algorithm. It sorts an array by repeatedly selecting the smallest (or largest) element 
    from the unsorted portion and swapping it with the first unsorted element. This process continues until the entire array is sorted.
        1. First we find the smallest element and swap it with the first element. This way we get the smallest element at its correct position.
        2. Then we find the smallest among remaining elements (or second smallest) and swap it with the second element.
        3. We keep doing this until we get all elements moved to correct position.
    Time Complexity: O(n2)*/

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) min = j;
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 9, 1, 7};
        sort(a);
        for (int x : a) System.out.print(x + " ");
    }
}
