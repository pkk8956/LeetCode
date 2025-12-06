package Sliding_Window;

public class LC_76 {

    //Minimum Window Substring

    /*Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such 
    that every character in t (including duplicates) is included in the window. 
    If there is no such substring, return the empty string "".*/

    public static void main(String[] args) {
        LC_76 obj = new LC_76();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(obj.minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        int[] charCount = new int[128];
        for (char c : t.toCharArray()) {
            charCount[c]++;
        }

        int left = 0, right = 0, required = t.length();
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;

        while (right < s.length()) {
            char currentChar = s.charAt(right);
            if (charCount[currentChar] > 0) {
                required--;
            }
            charCount[currentChar]--;
            right++;

            while (required == 0) {
                if (right - left < minLength) {
                    minLength = right - left;
                    minLeft = left;
                }
                char leftChar = s.charAt(left);
                charCount[leftChar]++;
                if (charCount[leftChar] > 0) {
                    required++;
                }
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }
    
}
