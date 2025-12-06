package Dynamic_programming;

public class LC_198 {

    //House Robber

    /*You are a professional robber planning to rob houses along a street. Each house has a certain 
    mount of money stashed, the only constraint stopping you from robbing each of them is that adjacent 
    houses have security systems connected and it will automatically contact the police if two adjacent 
    houses were broken into on the same night. Given an integer array nums representing the amount of money
    of each house, return the maximum amount of money you can rob tonight without alerting the police.*/

    public static void main(String[] args) {
        LC_198 obj = new LC_198();
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(obj.rob(nums));
    }

    public int rob(int[] nums) {
        if(nums.length < 2) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
            
        for(int i = 2 ; i<nums.length ; i++){
            dp[i] = Math.max(dp[i-2] + nums[i] , dp[i-1]);
        }
        return dp[nums.length-1];
    }
}
