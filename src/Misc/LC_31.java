package Misc;

public class LC_31 {

    //Next Permutation

    /*A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
    The next permutation of an array of integers is the next lexicographically greater permutation of its integer.
    If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
    The replacement must be in place and use only constant extra memory.*/

    public static void main(String[] args) {
        LC_31 obj = new LC_31();
        int[] nums = {1, 2, 3};
        obj.nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
}
