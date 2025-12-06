package Searching;

import java.util.Arrays;

public class BinarySearch {

    // Binary Search Algorithm
    
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 9};
        Arrays.sort(numbers);
        int target = 7;
        int index = binarySearch(numbers, target);
        if (index != -1) {
            System.out.println("Element index is " + index);
        } else {
            System.out.println("Element not found");
        }
    }
}
