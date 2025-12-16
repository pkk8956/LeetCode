package String_Search;

import java.util.*;

public class SuffixArray {

    // Time Complexity: O(N log N) for building suffix array, O(M log N) for each search where N is length of haystack and M is length of needle
    // Space Complexity: O(N)

    private final String haystack;
    private final int[] suffixArray;

    public SuffixArray(String haystack) {
        this.haystack = haystack;
        this.suffixArray = buildSuffixArray(haystack);
    }

    private int[] buildSuffixArray(String s) {
        int n = s.length();
        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> {
            int i = a;
            int j = b;
            while (i < n && j < n) {
                if (s.charAt(i) != s.charAt(j)) {
                    return s.charAt(i) - s.charAt(j);
                }
                i++;
                j++;
            }
            return (n - a) - (n - b);
        });

        int[] sa = new int[n];
        for (int i = 0; i < n; i++) {
            sa[i] = indices[i];
        }

        return sa;
    }

    public List<Integer> search(String needle) {
        List<Integer> result = new ArrayList<>();

        int left = lowerBound(needle);
        int right = upperBound(needle);

        for (int i = left; i < right; i++) {
            result.add(suffixArray[i]);
        }

        return result;
    }

    private int lowerBound(String needle) {
        int l = 0;
        int r = suffixArray.length;

        while (l < r) {
            int mid = (l + r) / 2;
            if (compare(needle, suffixArray[mid]) > 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    private int upperBound(String needle) {
        int l = 0;
        int r = suffixArray.length;

        while (l < r) {
            int mid = (l + r) / 2;
            if (compare(needle, suffixArray[mid]) >= 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    private int compare(String needle, int suffixIndex) {
        int i = 0;
        int n = haystack.length();

        while (i < needle.length() && suffixIndex + i < n) {
            if (needle.charAt(i) != haystack.charAt(suffixIndex + i)) {
                return needle.charAt(i) - haystack.charAt(suffixIndex + i);
            }
            i++;
        }

        if (i == needle.length()) {
            return 0;
        }

        return 1;
    }
}
