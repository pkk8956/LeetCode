package Sliding_Window;

import java.util.ArrayList;
import java.util.List;

public class LC_438 {

    //Find All Anagrams in a String

    /*Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.*/

    public static void main(String[] args) {
        LC_438 obj = new LC_438();
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(obj.findAnagrams(s, p));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return result;

        int[] charCount = new int[128];
        for (char c : p.toCharArray()) {
            charCount[c]++;
        }

        int left = 0, right = 0, count = p.length();

        while (right < s.length()) {
            char currentChar = s.charAt(right);
            if (charCount[currentChar] >= 1) {
                count--;
            }
            charCount[currentChar]--;
            right++;

            if (count == 0) {
                result.add(left);
            }

            if (right - left == p.length()) {
                char leftChar = s.charAt(left);
                if (charCount[leftChar] >= 0) {
                    count++;
                }
                charCount[leftChar]++;
                left++;
            }
        }

        return result;
    }
    
}
