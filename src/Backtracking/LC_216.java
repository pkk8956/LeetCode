package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC_216 {

    //Combination Sum III

    /*Find all possible combinations of k numbers that add up to a number n, given that only numbers 
    from 1 to 9 can be used and each combination should be a unique set of numbers.
    Note:
    -- All numbers will be positive integers.
    -- The solution set must not contain duplicate combinations. */

    public static void main(String[] args) {
        LC_216 obj = new LC_216();
        int k = 3;
        int n = 7;
        System.out.println(obj.combinationSum3(k, n));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int k, int remain, int start) {
        if (tempList.size() == k && remain == 0) result.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i <= 9; i++) {
                tempList.add(i);
                backtrack(result, tempList, k, remain - i, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
