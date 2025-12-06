package Sorting;

public class RadixSort {
    
    /*Radix Sort is a non-comparative integer sorting algorithm that sorts numbers by processing individual digits. 
    It works by sorting the numbers based on each digit, starting from the least significant digit (LSD) to the most significant digit (MSD).
        1. Find the maximum number to determine the number of digits.
        2. Starting from the least significant digit, sort the array using a stable sorting algorithm (like Counting Sort) for each digit.
        3. Repeat the process for each digit until all digits have been processed.
    Time Complexity: O(d*(n + k)) where d is the number of digits, n is the number of elements, and k is the range of the input.*/

    public static void sort(int[] arr) {
        int max = getMax(arr);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            if (i > max) max = i;
        }
        return max;
    }

    private static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] a = {170, 45, 75, 90, 802, 24, 2, 66};
        sort(a);
        for (int x : a) System.out.print(x + " ");
    }
}
