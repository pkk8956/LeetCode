package String_Search;

import java.util.ArrayList;
import java.util.List;

public class NaiveSearch {

    // Time Complexity: O((N-M+1)*M) where N is length of haystack and M is length of needle
    // Space Complexity: O(1)

    public static List<Integer> search(String haystack, String needle) {
        List<Integer> result = new ArrayList<>();

        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;

            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == m) {
                result.add(i);
            }
        }

        return result;
    }

    
}
