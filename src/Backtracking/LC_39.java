package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_39 {

    //Combination Sum

    /*Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.*/

    public static void main(String[] args) {
        LC_39 obj = new LC_39();
        int[] candidates = {2,3,6,7};      
        System.out.println(obj.combinationSum(candidates, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> path, int[] candidates, int remain, int start) {

        if(remain == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = start; i < candidates.length; i ++){
            int num = candidates[i];
            if (num > remain) break;

            path.add(num);
            backtrack(result, path, candidates, remain - num, i);
            path.remove(path.size() - 1);
        }
    }
}
