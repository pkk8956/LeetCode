package Arrays_and_Strings;

import java.util.Arrays;

public class LC_88 {

    // Merge Sorted Array

    /* You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
    and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
    Merge nums1 and nums2 into a single array sorted in non-decreasing order.
    The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
    To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
    and the last n elements are set to 0 and should be ignored.*/

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        LC_88 obj = new LC_88();
        obj.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Start from the end of both arrays
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        // Merge from the end
        while (i >= 0 && j >= 0) {
            // Compare elements from nums1 and nums2 and place the larger one at the end of nums1
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i]; // Place element from nums1
                i--; // Move pointer in nums1
            } else {
                nums1[k] = nums2[j];
                j--; // Move pointer in nums2
            }
            k--; // Move pointer in nums1 for the next position
        }

        // Copy any remaining elements from nums2
        while (j >= 0) {
            // If there are remaining elements in nums2, copy them
            nums1[k] = nums2[j];
            j--; // Move pointer in nums2
            k--; // Move pointer in nums1
        }
    }
}