package Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC_46 {

    //Permutations

    /*Given an array nums of distinct integers, return all the possible . You can return the answer in any order.*/

    public static void main(String[] args) {
        LC_46 obj = new LC_46();      
        int[] nums = {1, 2, 3};
        System.out.println(obj.permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        
        if (nums.length == 0) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(result, nums, new ArrayList<Integer>(), used);
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, List<Integer> permutation, boolean[] used) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i <nums.length; i ++){
            if (used[i]) continue;
            permutation.add(nums[i]);
            used[i] = true;
            backtrack(result, nums, permutation, used);
            permutation.remove(permutation.size() - 1);
            used[i] = false;
        }
    }

}
