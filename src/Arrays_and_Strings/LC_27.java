package Arrays_and_Strings;

public class LC_27 {

    // Remove Element

    /* Given an array nums and a value val, remove all instances of that value in-place and return the new length.
    Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
    The order of elements can be changed. It doesn't matter what you leave beyond the new length.*/

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        LC_27 obj = new LC_27();
        System.out.println(obj.removeElement(nums, val));
    }

    public int removeElement(int[] nums, int val) {
        // Pointer for the position to place the next non-val element
        int i = 0;
        // Iterate through the array
        for (int j = 0; j < nums.length; j++) {
            // If the current element is not val, place it at index i
            if (nums[j] != val) {
                // Place the non-val element at index i
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}