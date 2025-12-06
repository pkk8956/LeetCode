package Misc;

public class LC_136 {
    //Single Number

    /*Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
    You must implement a solution with a linear runtime complexity and use only constant extra space.*/

    public static void main(String[] args) {
        LC_136 obj = new LC_136();
        int[] nums = {4,1,2,1,2};
        System.out.println(obj.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
    
}
