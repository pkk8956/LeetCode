package Sliding_Window;

public class LC_209 {

    //Minimum Size Subarray Sum

    /*Given an array of positive integers nums and a positive integer target, 
    return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] 
    of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.*/

    public static void main(String[] args) {
        LC_209 obj = new LC_209();
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        int result = obj.minSubArrayLen(target, nums);
        System.out.println("Minimal Length: " + result);
    }

    public int minSubArrayLen(int target, int[] nums) {
        //Sliding Window Approach
        int left = 0, sum = 0, minLength = Integer.MAX_VALUE;
        //Expand the window by moving the right pointer
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            //Shrink the window as small as possible while the sum is >= target
            while (sum >= target) {
                //Update the minimum length
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
    
}
