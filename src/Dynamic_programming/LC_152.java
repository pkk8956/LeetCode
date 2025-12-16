package Dynamic_Programming;

public class LC_152 {

    //Maximum Product Subarray

    /*Given an integer array nums, find a subarray that has the largest product, and return the product.
    The test cases are generated so that the answer will fit in a 32-bit integer.
    Note that the product of an array with a single element is the value of that element.*/

    public static void main(String[] args) {
        LC_152 obj = new LC_152();
        int[] nums = {2, 3, -2, 4};
        System.out.println(obj.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (cur < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(cur, max * cur);
            min = Math.min(cur, min * cur);
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
