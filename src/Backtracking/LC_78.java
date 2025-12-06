package Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC_78 {

    //Subsets

    /*Given an integer array nums of unique elements, return all possible (the power set).
    The solution set must not contain duplicate subsets. Return the solution in any order.*/

     public static void main(String[] args) {
        LC_78 obj = new LC_78(); 
        int[] nums = {1, 2, 3};
        System.out.println(obj.subsets(nums));
        System.out.println(obj.subsets(nums, true));
    }

    public List<List<Integer>> subsets(int[] nums, boolean b) {
        
        if (nums.length == 0) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        int total = 1 << n; 

        for (int mask = 0; mask < total; mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0){
                    subset.add(nums[i]);
                }
            }
            result.add(subset);
        }
        return result;
    }

    public List<List<Integer>> subsets(int[] nums) {
        
        if (nums.length == 0) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> subset, int[] nums, int start) {
        result.add(new ArrayList<>(subset));

      
        for (int i = start; i < nums.length; i ++){
            subset.add(nums[i]);
            backtrack(result, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
