package Dynamic_Programming;

public class LC_72 {

    //Edit Distance

    /*Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2. 
    You have the following three operations permitted on a word:
        - Insert a character
        - Delete a character
        - Replace a character
*/

    public static void main(String[] args) {
        LC_72 obj = new LC_72();  
            
        System.out.println(obj.minDistance("horse", "ros"));
    }

    public int minDistance(String word1, String word2) {
        if (word1 == null) word1 = "";
        if (word2 == null) word2 = "";

        int n = word1.length();
        int m = word2.length();

        if (n == 0) return m;
        if (m == 0) return n;

        if (m > n) {
            String tmp = word1; word1 = word2; word2 = tmp;
            int t = n; n = m; m = t;
        }

        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];

        for (int j = 0; j <= m; j++) prev[j] = j;

        for (int i = 1; i <= n; i++) {
            curr[0] = i;
            char c1 = word1.charAt(i - 1);

            int left = curr[0];
            int upLeft = prev[0];

            for (int j = 1; j <= m; j++) {
                int up = prev[j];
                char c2 = word2.charAt(j - 1);

                int val;
                if (c1 == c2) {
                    val = upLeft;
                } else {
                    int insert = left + 1;
                    int delete = up + 1;
                    int replace = upLeft + 1;

                    val = insert < delete ? insert : delete;
                    if (replace < val) val = replace;
                }

                curr[j] = val;
                upLeft = up;
                left = val;
            }

            int[] tmp = prev; prev = curr; curr = tmp;
        }

     return prev[m];
    }

// public int minDistance(String word1, String word2) {
//     int n = word1.length();
//     int m = word2.length();

//     int[][] dp = new int[n + 1][m + 1];

//     for (int i = 0; i <= n; i++) dp[i][0] = i;
//     for (int j = 0; j <= m; j++) dp[0][j] = j;

//     for (int i = 1; i <= n; i++) {
//         for (int j = 1; j <= m; j++) {

//             if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
//                 dp[i][j] = dp[i - 1][j - 1];
//             } else {
//                 int insert = dp[i][j - 1] + 1;
//                 int delete = dp[i - 1][j] + 1;
//                 int replace = dp[i - 1][j - 1] + 1;

//                 dp[i][j] = Math.min(insert, Math.min(delete, replace));
//             }
//         }
//     }

//     return dp[n][m];
// }


}
