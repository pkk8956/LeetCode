package Hash_Map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class LC_2215 {

    //Find the Difference of Two Arrays

    /*Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
    answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
    answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
    Note that the integers in the lists may be returned in any order.*/

    public static void main(String[] args) {
        LC_2215 obj = new LC_2215();
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4,6};
        System.out.println(obj.findDifference(nums1, nums2)); 
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);

        List<Integer> diff1 = new ArrayList<>();
        List<Integer> diff2 = new ArrayList<>();

        for (int num : set1) {
            if (!set2.contains(num)) diff1.add(num);
        }

        for (int num : set2) {
            if (!set1.contains(num)) diff2.add(num);
        }

        return Arrays.asList(diff1, diff2);
    }
}