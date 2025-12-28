package Bit_Manipulation;

public class LC_137 {

    // Single Number II

    /*Given an integer array nums where every element appears three times except for one, 
    which appears exactly once. Find the single element and return it.
    You must implement a solution with a linear runtime complexity and use only constant extra space. */

    public static void main(String[] args) {
        LC_137 obj = new LC_137();
        int[] nums = {0,1,0,1,0,1,99};
        System.out.println(obj.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;

        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }
}
