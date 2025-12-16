package String_Search;

import java.util.ArrayList;
import java.util.List;

public class RabinKarpSearch {

    private static final int d = 256;
    private static final long q = 1_000_000_007;

    public static List<Integer> search(String haystack, String needle) {
        List<Integer> result = new ArrayList<>();

        int n = haystack.length();
        int m = needle.length();

        if (m > n) {
            return result;
        }

        long needleHash = 0;
        long windowHash = 0;
        long h = 1;

        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        for (int i = 0; i < m; i++) {
            needleHash = (d * needleHash + needle.charAt(i)) % q;
            windowHash = (d * windowHash + haystack.charAt(i)) % q;
        }

        for (int i = 0; i <= n - m; i++) {
            if (needleHash == windowHash) {
                int j = 0;
                while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                    j++;
                }
                if (j == m) {
                    result.add(i);
                }
            }

            if (i < n - m) {
                windowHash = (d * (windowHash - haystack.charAt(i) * h)
                        + haystack.charAt(i + m)) % q;

                if (windowHash < 0) {
                    windowHash += q;
                }
            }
        }

        return result;
    }

}
