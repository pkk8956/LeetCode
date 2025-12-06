package Sorting;

public class GnomeSort {

    /*Gnome Sort is a simple comparison-based sorting algorithm that is similar to Insertion Sort but with a different approach. 
    It works by iterating through the array and swapping adjacent elements that are out of order, moving backwards when a swap is made.
        1. Start at the first element of the array.
        2. Compare the current element with the previous element.
        3. If they are in the correct order, move one step forward.
        4. If they are out of order, swap them and move one step backward (if possible).
        5. Repeat this process until you reach the end of the array.
    Time Complexity: O(n2)*/

    public static void sort(int[] arr) {
        int index = 0;
        int n = arr.length;

        while (index < n) {
            if (index == 0) {
                index++;
            }
            if (arr[index] >= arr[index - 1]) {
                index++;
            } else {
                int temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 9, 1, 7};
        sort(a);
        for (int x : a) System.out.print(x + " ");
    }
    
}
