package Sorting;

public class CocktailSort {

    /*Cocktail Sort, also known as Bidirectional Bubble Sort or Shaker Sort, is a variation of Bubble Sort 
    that sorts the array in both directions. 
    It works by repeatedly passing through the array in both directions, moving the largest unsorted 
    elements to the end and the smallest unsorted elements to the beginning.
        1. Start from the beginning of the array and move towards the end, comparing adjacent elements 
           and swapping them if they are out of order.
        2. Once you reach the end, reverse direction and move back towards the beginning, again comparing and swapping adjacent elements.
        3. Repeat this process until no swaps are needed in both directions, indicating that the array is sorted.
    Time Complexity: O(n2)*/

    public static void sort(int[] arr) {
        boolean swapped = true;
        int start = 0;
        int end = arr.length - 1;

        while (swapped) {
            swapped = false;

            for (int i = start; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }
            }

            if (!swapped) break;

            swapped = false;
            end--;

            for (int i = end - 1; i >= start; i--) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }
            }
            start++;
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 9, 1, 7};
        sort(a);
        for (int x : a) System.out.print(x + " ");
    }
    
}
