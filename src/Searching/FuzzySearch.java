package Searching;

public class FuzzySearch {

    // Fuzzy Search using Levenshtein Distance
    // Time Complexity: O(N*M) where N and M are lengths of the two strings
    // Space Complexity: O(N*M)

    public static int levenshteinDistance(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) dp[i][0] = i;
        for (int j = 0; j <= b.length(); j++) dp[0][j] = j;

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                        dp[i - 1][j - 1],
                        Math.min(dp[i - 1][j], dp[i][j - 1])
                    );
                }
            }
        }

        return dp[a.length()][b.length()];
    }

    public static void main(String[] args) {
        String target = "hello";
        String input = "helo";  

        int distance = levenshteinDistance(target, input);
        System.out.println("Levenshtein distance: " + distance);

        if (distance <= 1) {
            System.out.println("Strings are similar");
        } else {
            System.out.println("Strings are different");
        }
    }
}
