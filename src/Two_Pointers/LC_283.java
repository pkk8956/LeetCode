package Two_Pointers;

public class LC_283 {

    //Move Zeroes

    /*Given an integer array nums, move all 0's to the end of it while maintaining the relative order 
    of the non-zero elements. Note that you must do this in-place without making a copy of the array.*/

    public static void main(String[] args) {
        LC_283 obj = new LC_283();
        int[] nums = {0,1,0,3,12};
        obj.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public void moveZeroes(int[] nums) {
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
    }
    
}
