package Dynamic_Programming;

public class LC_918 {

    //Maximum Sum Circular Subarray

    /*Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
    A circular array means the end of the array connects to the beginning of the array. Formally, the next element of 
    nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].
    A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], 
    nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n. */

    public static void main(String[] args) {
        LC_918 obj = new LC_918();
        int[] nums =  {1,-2,3,-2};
        System.out.println(obj.maxSubarraySumCircular(nums));
    }

    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int[] dpMax = new int[n];
        int[] dpMin = new int[n];

        int totalSum = nums[0];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];

        int maxNormal = nums[0];
        int minSubarray = nums[0];

        for (int i = 1; i < n; i++) {
            dpMax[i] = Math.max(nums[i], dpMax[i - 1] + nums[i]);
            maxNormal = Math.max(maxNormal, dpMax[i]);

            dpMin[i] = Math.min(nums[i], dpMin[i - 1] + nums[i]);
            minSubarray = Math.min(minSubarray, dpMin[i]);

            totalSum += nums[i];
        }

        // If all numbers are negative
        if (maxNormal < 0)  return maxNormal;

        return Math.max(maxNormal, totalSum - minSubarray);
    }
    
}
