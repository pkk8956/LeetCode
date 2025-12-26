package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC_77 {

    //Combinations

    /*Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
    You may return the answer in any order. */

    public static void main(String[] args) {
        LC_77 obj = new LC_77();
        int n = 4, k = 2;
        List<List<Integer>> result = obj.combine(n, k);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        backtrack(1, n, k, combination, result);
        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> combination, List<List<Integer>> result) {
        // If combination size reaches k, add it to the result
        if (combination.size() == k) {
            result.add(new ArrayList<>(combination));
            return;
        }

        // Try every number from 'start' to 'n'
        for (int i = start; i <= n; i++) {
            combination.add(i);               // Choose
            backtrack(i + 1, n, k, combination, result); // Explore
            combination.remove(combination.size() - 1);  // Un-choose (backtrack)
        }
    }
}
