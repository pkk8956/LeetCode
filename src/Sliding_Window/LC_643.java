package Sliding_Window;

public class LC_643 {

    //Maximum Average Subarray I

    /*Given an array consisting of n integers, find the contiguous subarray of given length k 
    that has the maximum average value. And you need to output the maximum average value.*/

    public static void main(String[] args) {
        LC_643 obj = new LC_643();
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(obj.findMaxAverage(nums, k));
    }

    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int windowSum = 0;
        double maxAverage = Double.NEGATIVE_INFINITY;

        while (right < nums.length) {
            windowSum += nums[right];

            if (right - left + 1 > k) {
                windowSum -= nums[left];
                left++;
            }

            if (right - left + 1 == k) {
                maxAverage = Math.max(maxAverage, (double) windowSum / k);
            }

            right++;
        }

        return maxAverage;
    }
    
}
