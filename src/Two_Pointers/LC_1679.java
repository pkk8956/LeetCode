package Two_Pointers;

import java.util.Arrays;

public class LC_1679 {

    //Max Number of K-Sum Pairs

    /*You are given an integer array nums and an integer k.
    In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
    Return the maximum number of operations you can perform on the array.*/

    public static void main(String[] args) {
        LC_1679 obj = new LC_1679();
        int[] nums = {1,2,3,4};
        int k = 5;
        System.out.println(obj.maxOperations(nums, k));
    }

    public int maxOperations(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        int count = 0;
        Arrays.sort(nums);

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                count++;
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
    
}
