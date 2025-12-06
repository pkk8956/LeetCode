package Sorting;

public class InsertionSort {

    /*Insertion Sort is a simple comparison-based sorting algorithm that builds a sorted array one element at a time. 
    It works by taking an element from the unsorted portion and inserting it into its correct position in the sorted portion.
        1. We start with the second element (index 1) and compare it with the elements before it.
        2. If the current element is smaller than the previous elements, we shift the larger elements one 
           position to the right to make space for the current element.
        3. We insert the current element into its correct position.
        4. This process is repeated for all elements in the array until the entire array is sorted.
    Time Complexity: O(n2)*/

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 9, 1, 7};
        sort(a);
        for (int x : a) System.out.print(x + " ");
    }
    
}
