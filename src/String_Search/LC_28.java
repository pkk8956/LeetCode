package String_Search;

public class LC_28 {

    // Find the Index of the First Occurrence in a String

    /* Given two strings needle and haystack, return the index of the first occurrence 
    of needle in haystack, or -1 if needle is not part of haystack.*/

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        LC_28 obj = new LC_28();
        System.out.println(obj.strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();

        // Edge case: if needle is empty, return 0
        if (nLen == 0) return 0;

        // Loop through haystack to find the needle
        for (int i = 0; i <= hLen - nLen; i++) {
            // Check if the substring matches the needle
            if (haystack.substring(i, i + nLen).equals(needle)) {
                return i; // Return the starting index of the first occurrence
            }
        }
        return -1; // Needle not found in haystack
    }
    
}
