package Misc;

public class LC_238 {

    //Product of Array Except Self

    /*Given an integer array nums, return an array answer such that answer[i] is equal to the product 
    of all the elements of nums except nums[i].
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    You must write an algorithm that runs in O(n) time and without using the division operation.*/

    public static void main(String[] args) {
        LC_238 obj = new LC_238();
        int[] nums = {1,2,3,4};
        int[] result = obj.productExceptSelf(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return answer;
    }
}
