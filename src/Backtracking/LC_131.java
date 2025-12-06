package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC_131 {

    //Palindrome Partitioning

    /*Given a string s, partition s such that every substring of the partition is a palindrome.
    Return all possible palindrome partitioning of s.*/

    public static void main(String[] args) {
        LC_131 obj = new LC_131();      
        System.out.println(obj.partition("aab"));
    }

    public List<List<String>> partition(String s) {
        
        List<List<String>> result = new ArrayList<>();
        int n = s.length();

        boolean[][] dp = new boolean[n][n];
        for (int right = 0; right < n; right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }

        backtrack(s, 0, new ArrayList<>(), result, dp);
        return result;
    }

    private void backtrack(String s, int start, List<String> path, List<List<String>> result, boolean[][] dp) {

        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) {
                path.add(s.substring(start, end + 1)); 
                backtrack(s, end + 1, path, result, dp);
                path.remove(path.size() - 1);
            }
        }

    }
}
