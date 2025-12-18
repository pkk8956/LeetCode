package Arrays_and_Strings;

public class LC_80 {

    // Remove Duplicates from Sorted Array II

    /* Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most 
    twice and return the new length.
    Do not allocate extra space for another array; you must do this by modifying the input array in-place 
    with O(1) extra memory.*/

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        LC_80 obj = new LC_80();
        System.out.println(obj.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        // If the array has 2 or f
        // ewer elements, return its length
        if (n <= 2) return n;
        // Write index to place the next allowed element
        int writeIndex = 2; 

        for (int i = 2; i < n; i++) {
            // Check if the current number is different from the number two positions before
            if (nums[i] != nums[writeIndex - 2]) {
                // If it's different, it's allowed, so we write it at the writeIndex
                nums[writeIndex] = nums[i];
                // Move the writeIndex forward
                writeIndex++;
            }
        }
        return writeIndex;
    }
    
}
