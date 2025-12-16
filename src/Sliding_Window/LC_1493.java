package Sliding_Window;

public class LC_1493 {

    // Longest Subarray of 1's After Deleting One Element

    /*Given a binary array nums, you should delete one element from it.
    Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.*/

    public static void main(String[] args) {
        LC_1493 obj = new LC_1493();
        int[] nums = {1,1,0,1};
        System.out.println(obj.longestSubarray(nums));
    }

    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int zeroCount = 0;
        int maxLength = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left);
            right++;
        }

        return maxLength;
    }
    
}
