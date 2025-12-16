package Dynamic_Programming;

import java.util.Arrays;

public class LC_279 {

    //Climbing Stairs

    /*Given an integer n, return the least number of perfect square numbers that sum to n. 
    A perfect square is an integer that is the square of an integer; in other words, it is
    the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect 
    squares while 3 and 11 are not.*/

    public static void main(String[] args) {
        LC_279 obj = new LC_279();  
            
        System.out.println(obj.numSquares(456));
        System.out.println(obj.numSquares(456, true));
    }

    public int numSquares(int n) {
        if (isPerfectSquare(n)) return 1;

        // Проверяем, можно ли представить n как сумму двух квадратов
        for (int i = 1; i * i <= n; i++) {
            if (isPerfectSquare(n - i * i)) return 2;
        }

        // Проверяем условие Лежандра для 4 квадратов
        int temp = n;
        while (temp % 4 == 0) temp /= 4;
        if (temp % 8 == 7) return 4;

        // Если ни одно из условий не выполнено, то ответ 3
        return 3;
    }

    private boolean isPerfectSquare(int x) {
        int sqrt = (int) Math.sqrt(x);
        return sqrt * sqrt == x;
    }

     public int numSquares(int n, boolean b) {
        int maxRoot = (int) Math.sqrt(n);
        int[] squares = new int[maxRoot];
        for (int i = 1; i <= maxRoot; i++) {
            squares[i - 1] = i * i;
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int sq : squares) {
                if (sq > i) break;
                dp[i] = Math.min(dp[i], dp[i - sq] + 1);
            }
        }
        return dp[n];
    }
}
