package Greedy;

public class LC_55 {

    //Jump Game

    /*You are given an integer array nums. You are initially positioned at the array's first index, 
    and each element in the array represents your maximum jump length at that position.
    Return true if you can reach the last index, or false otherwise.*/

    public static void main(String[] args) {
        LC_55 obj = new LC_55();  
        int[] nums = {2,3,1,1,4};
        System.out.println(obj.canJump(nums));
    }

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i <= max; i++) {
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) return true;
        }
        return false;
    }

}
