package String_Search;

import java.util.ArrayList;
import java.util.List;

public class KMPSearch {

    // Time Complexity: O(N + M) where N is length of haystack and M is length of needle
    // Space Complexity: O(M)e

    public static List<Integer> search(String haystack, String needle) {
        List<Integer> result = new ArrayList<>();

        int n = haystack.length();
        int m = needle.length();

        int[] lps = buildLps(needle);

        int i = 0;
        int j = 0;

        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                result.add(i - j);
                j = lps[j - 1];
            } else if (i < n && haystack.charAt(i) != needle.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result;
    }

    private static int[] buildLps(String needle) {
        int m = needle.length();
        int[] lps = new int[m];

        int len = 0;
        int i = 1;

        while (i < m) {
            if (needle.charAt(i) == needle.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

}
