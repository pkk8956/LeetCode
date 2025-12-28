package Dynamic_Programming;

import java.util.ArrayList;
import java.util.List;

public class LC_120 {

    // Triangle

    /*Given a triangle array, return the minimum path sum from top to bottom.
    For each step, you may move to an adjacent number of the row below. 
    More formally, if you are on index i on the current row, you 
    may move to either index i or index i + 1 on the next row. */

    public static void main(String[] args) {
        LC_120 obj = new LC_120();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(2));
        triangle.add(List.of(3,4));
        triangle.add(List.of(6,5,7));
        triangle.add(List.of(4,1,8,3));
        System.out.println(obj.minimumTotal(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        // Инициализация последнего ряда
        for (int j = 0; j < n; j++) {
            dp[j] = triangle.get(n - 1).get(j);
        }

        // Снизу вверх
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }
    
}
