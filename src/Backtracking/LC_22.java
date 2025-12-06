package Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC_22 {

    //Generate Parentheses

    /*Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.*/

    public static void main(String[] args) {
        LC_22 obj = new LC_22();      
        System.out.println(obj.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {

        if (n <=0) return Collections.emptyList();
        List<String> result = new ArrayList<>();
        backtrack(result, n, 0, 0, new StringBuilder());

        return result;
    }

    private void backtrack(List<String> result, int n, int open, int close, StringBuilder pairs) {

        if (pairs.length() == n * 2){
            result.add(pairs.toString());
            return;
        }

        if (open < n){
            pairs.append('(');
            backtrack(result, n, open + 1, close, pairs);
            pairs.deleteCharAt(pairs.length() - 1);
        }

        if (close < open){
            pairs.append(')');
            backtrack(result, n, open, close + 1, pairs);
            pairs.deleteCharAt(pairs.length() - 1);
        }
    }

}
