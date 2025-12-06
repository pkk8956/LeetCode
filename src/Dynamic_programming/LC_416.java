package Dynamic_programming;

public class LC_416 {

    //Partition Equal Subset Sum

    /*Given an integer array nums, return true if you can partition the array into 
    two subsets such that the sum of the elements in both subsets is equal or false otherwise.*/

    public static void main(String[] args) {
        LC_416 obj = new LC_416();
        int[] nums = {1,5,11,5}; 
        System.out.println(obj.canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int x : nums) sum += x;

        if (sum % 2 != 0) return false;

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int s = target; s >= num; s--) {
                if (dp[s - num]) dp[s] = true;
            }
        }

        return dp[target];
    }
}
