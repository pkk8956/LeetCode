package Sorting;

public class CountingSort {

    /*Counting Sort is a non-comparison-based sorting algorithm that is efficient for sorting integers within a specific range. 
    It works by counting the occurrences of each unique element in the input array and using this information to place the elements in their correct positions in the output array.
        1. Find the maximum value in the input array to determine the range of the counting array.
        2. Create a counting array to store the count of each unique element.
        3. Iterate through the input array and populate the counting array.
        4. Modify the counting array by adding the count of previous elements to get the position of each element in the output array.
        5. Build the output array by placing elements at their correct positions based on the counting array.
        6. Copy the sorted elements from the output array back to the input array.
    Time Complexity: O(n + k), where n is the number of elements in the input array and k is the range of the input values.*/

    public static void sort(int[] arr) {
        int n = arr.length;
        if (n == 0) return;

        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) max = arr[i];
        }

        int[] count = new int[max + 1];
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 9, 1, 7};
        sort(a);
        for (int x : a) System.out.print(x + " ");
    }
    
}
