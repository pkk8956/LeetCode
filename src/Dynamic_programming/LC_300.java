package Dynamic_programming;

public class LC_300 {

    //Longest Increasing Subsequence

    /*Given an integer array nums, return the length of the longest strictly increasing subsequence.*/

    public static void main(String[] args) {
        LC_300 obj = new LC_300();
        int[] nums = {10,9,2,5,3,7,101,18}; 
        System.out.println(obj.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = 1;

        for (int i = 0; i < n; i++) {
            dp[i] = 1; 
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
