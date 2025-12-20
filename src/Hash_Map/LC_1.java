package Hash_Map;

import java.util.HashMap;
import java.util.Map;

public class LC_1 {

    //Two Sum

    /*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.*/

    public static void main(String[] args) {
        LC_1 obj = new LC_1();  
        int[] nums = {2,7,11,15};
        System.out.println(obj.twoSum(nums, 9));
    }

    public int[] twoSum(int[] nums, int target) {
         Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }

}
