package Advanced_Data_Structures;

public class LC_724 {

    // Find Pivot Index

    /*Given an array of integers nums, calculate the pivot index of this array.
    The pivot index is the index where the sum of all the numbers strictly to the left of the index 
    is equal to the sum of all the numbers strictly to the index's right.
    If the index is on the left edge of the array, then the left sum is 0 because there are no elements 
    to the left. This also applies to the right edge of the array.
    Return the leftmost pivot index. If no such index exists, return -1.*/

    public static void main(String[] args) {
        LC_724 obj = new LC_724();
        int[] nums = {1,7,3,6,5,6};
        System.out.println(obj.pivotIndex(nums));
    }

    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
