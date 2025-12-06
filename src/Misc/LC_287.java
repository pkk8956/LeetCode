package Misc;

public class LC_287 {

    //Find the Duplicate Number

    /*Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
    There is only one repeated number in nums, return this repeated number.
    You must solve the problem without modifying the array nums and uses only constant extra space.*/

    public static void main(String[] args) {
        LC_287 obj = new LC_287();
        int[] nums = {1,3,4,2,2};
        System.out.println(obj.findDuplicate(nums));
    }

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
    
}
