package String_Search;

import java.util.ArrayList;
import java.util.List;

public class BoyerMooreSearch {

    // Time Complexity: O(N/M) on average, O(N*M) in worst case where N is length of haystack and M is length of needle
    // Space Complexity: O(ALPHABET)

    private static final int ALPHABET = 256;

    private static int[] buildBadChar(String needle) {
        int[] badChar = new int[ALPHABET];

        for (int i = 0; i < ALPHABET; i++) {
            badChar[i] = -1;
        }

        for (int i = 0; i < needle.length(); i++) {
            badChar[needle.charAt(i)] = i;
        }

        return badChar;
    }

    public static List<Integer> search(String haystack, String needle) {
        List<Integer> result = new ArrayList<>();

        int n = haystack.length();
        int m = needle.length();

        int[] badChar = buildBadChar(needle);

        int shift = 0;

        while (shift <= n - m) {
            int j = m - 1;

            while (j >= 0 && needle.charAt(j) == haystack.charAt(shift + j)) {
                j--;
            }

            if (j < 0) {
                result.add(shift);

                shift += (shift + m < n)
                        ? m - badChar[haystack.charAt(shift + m)]
                        : 1;
            } else {
                shift += Math.max(1, j - badChar[haystack.charAt(shift + j)]);
            }
        }

        return result;
    }
}

