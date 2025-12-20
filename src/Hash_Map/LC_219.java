package Hash_Map;

import java.util.HashSet;
import java.util.Set;

public class LC_219 {

    // Contains Duplicate II

    /*Given an integer array nums and an integer k, 
    return true if there are two distinct indices i and j 
    in the array such that nums[i] == nums[j] and abs(i - j) <= k. */

    public static void main(String[] args) {
        LC_219 obj = new LC_219();
        int[] nums = {1,2,3,1};
        System.out.println(obj.containsNearbyDuplicate(nums, 3));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k <= 0) return false;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) set.remove(nums[i - k]);
        }

    return false;
    }
}
