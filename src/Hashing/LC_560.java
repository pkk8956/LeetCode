package Hashing;

import java.util.HashMap;
import java.util.Map;

public class LC_560 {

    //Subarray Sum Equals K

    /*Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
    A subarray is a contiguous non-empty sequence of elements within an array.*/

    public static void main(String[] args) {
        LC_560 obj = new LC_560();  
        int[] nums = {1,1,1};
        System.out.println(obj.subarraySum(nums, 2));
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefix = 0;
        int count = 0;
        for (int num : nums) {
            prefix += num;
            if (map.containsKey(prefix - k)) {
                count += map.get(prefix - k);
            }
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return count;
    }
}
