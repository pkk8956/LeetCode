package Misc;

import java.util.Arrays;

public class LC_1480 {

    //Running Sum of 1D Array

    /*Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
    Return the running sum of nums.*/

    public static void main(String[] args) {
        LC_1480 obj = new LC_1480();      
        System.out.println(Arrays.toString(obj.runningSum( new int[] {1,2,3,4})));
    }

   public int[] runningSum(int[] nums) {
        
        int[] result = new int[nums.length];
        result[0] = nums[0];
        
        for(int i = 1; i < nums.length; i ++){
            result[i] = result[i - 1] + nums[i];
        }

    return result;
    }
}
