package Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC_139 {

    //Word Break

    /*Given a string s and a dictionary of strings wordDict, return true if s can be segmented into 
    a space-separated sequence of one or more dictionary words.
    Note that the same word in the dictionary may be reused multiple times in the segmentation.*/

    public static void main(String[] args) {
        LC_139 obj = new LC_139();
        List<String> wordDict = new ArrayList<>(Arrays.asList("apple", "pen"));
        String s = "applepenapple";
        System.out.println(obj.wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        int maxLen = 0;
        for (String w : wordDict) maxLen = Math.max(maxLen, w.length());

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int len = 1; len <= maxLen && len <= i; len++) {
                if (!dp[i - len]) continue;
                if (set.contains(s.regionMatches(i - len, s, i - len, len) 
                        ? s.substring(i - len, i) 
                        : "")) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
