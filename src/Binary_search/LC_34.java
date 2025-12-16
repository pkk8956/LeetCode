package Binary_Search;

import java.util.Arrays;

public class LC_34 {

    //Find First and Last Position of Element in Sorted Array

    /*Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
    If target is not found in the array, return [-1, -1].
    You must write an algorithm with O(log n) runtime complexity.*/

    public static void main(String[] args) {
        LC_34 obj = new LC_34();
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(obj.searchRange(nums, 8)));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};

        int left = findLeft(nums, target);
        if (left == -1) return new int[]{-1, -1};

        int right = findRight(nums, target, left);
        return new int[]{left, right};
    }

    private int findLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int res = -1;

        while (left <= right) {
            int mid = (left + right) >>> 1;

            if (nums[mid] >= target) {
                if (nums[mid] == target) res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }

    private int findRight(int[] nums, int target, int start) {
        int left = start, right = nums.length - 1;
        int res = -1;

        while (left <= right) {
            int mid = (left + right) >>> 1;

            if (nums[mid] <= target) {
                if (nums[mid] == target) res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }
}
