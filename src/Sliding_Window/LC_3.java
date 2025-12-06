package Sliding_Window;

public class LC_3 {

    //Longest Substring Without Repeating Characters

    /*Given a string s, find the length of the longest substring without duplicate characters.*/

    public static void main(String[] args) {
        LC_3 obj = new LC_3();
        String s = "abcabcbb";
        System.out.println(obj.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        int[] charIndex = new int[128];
        int left = 0, right = 0, maxLength = 0;

        while (right < s.length()) {
            char currentChar = s.charAt(right);
            left = Math.max(charIndex[currentChar], left);
            charIndex[currentChar] = right + 1;
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}