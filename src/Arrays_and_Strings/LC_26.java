package Arrays_and_Strings;

public class LC_26 {

    // Remove Duplicates from Sorted Array

    /* Given a sorted array nums, remove the duplicates in-place such 
    that each element appears only once and returns the new length.
    Do not allocate extra space for another array, you must do this 
    by modifying the input array in-place with O(1) extra memory.*/

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        LC_26 obj = new LC_26();
        System.out.println(obj.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        // Pointer for the position of the last unique element
        int k = 0;
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the current element is different from the last unique element
            if (nums[i] != nums[k]) {
                k++; // Move the pointer for unique elements
                // Update the position with the new unique element
                nums[k] = nums[i];
            }
        }
        return k + 1; 
    }
}