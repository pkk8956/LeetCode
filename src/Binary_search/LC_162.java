package Binary_Search;

public class LC_162 {

    // Find Peak Element

    /*A peak element is an element that is strictly greater than its neighbors.
    Given a 0-indexed integer array nums, return the index of any peak element.
    You may assume that nums[-1] = nums[n] = -∞.
    You must write an algorithm that runs in O(log n) time.*/

    public static void main(String[] args) {
        LC_162 obj = new LC_162();
        int[] nums = {1,2,3,1};
        System.out.println(obj.findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}