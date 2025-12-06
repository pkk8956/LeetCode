package Dynamic_programming;

public class LC_32 {

    //Longest Valid Parentheses

    /*Given a string containing just the characters '(' and ')', return 
    the length of the longest valid (well-formed) parentheses substring.*/

    public static void main(String[] args) {
        LC_32 obj = new LC_32();  
            
        System.out.println(obj.longestValidParentheses(")()())"));
    }

    public int longestValidParentheses(String s) {
       int n = s.length();
        if (n == 0) return 0;

        int[] dp = new int[n]; 
        int max = 0;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
                else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2;
                    if (i - dp[i - 1] - 2 >= 0) dp[i] += dp[i - dp[i - 1] - 2];
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
