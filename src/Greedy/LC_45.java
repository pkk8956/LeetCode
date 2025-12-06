package Greedy;

public class LC_45 {

    //Jump Game II

    /*You are given a 0-indexed array of integers nums of length n. You are initially positioned at index 0.
    Each element nums[i] represents the maximum length of a forward jump from index i. In other words, \
    if you are at index i, you can jump to any index (i + j) where:
        0 <= j <= nums[i] and
        i + j < n
    Return the minimum number of jumps to reach index n - 1. The test cases are generated such that you can reach index n - 1.*/

    public static void main(String[] args) {
        LC_45 obj = new LC_45();  
        int[] nums = {2,3,1,1,4};
        System.out.println(obj.jump(nums));
    }

    public int jump(int[] nums) {
        int jumps = 0, currentEnd = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }
        return jumps;
    }

}
