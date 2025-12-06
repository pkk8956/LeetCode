package Misc;

public class LC_169 {
    //Majority Element

    /*Given an array nums of size n, return the majority element.
    The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.*/

    public static void main(String[] args) {
        LC_169 obj = new LC_169();
        int[] nums = {3,2,3};
        System.out.println(obj.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
    
}
