package Arrays_and_Strings;

public class LC_14 {

    // Longest Common Prefix

    /* Write a function to find the longest common prefix string amongst an array of strings.
    If there is no common prefix, return an empty string "".*/

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        LC_14 obj = new LC_14();
        System.out.println(obj.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        // Edge case: if the array is empty, return an empty string
        if (strs == null || strs.length == 0) return "";
        // Start with the first string as the initial prefix
        String prefix = strs[0];
        // Compare the prefix with each string in the array
        for (int i = 1; i < strs.length; i++) {
            // Reduce the prefix until it matches the start of the current string
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}