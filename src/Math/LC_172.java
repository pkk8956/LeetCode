package Math;

public class LC_172 {
    
    // Factorial Trailing Zeroes

    /*Given an integer n, return the number of trailing zeroes in n!.
    Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.  */

    public static void main(String[] args) {
        LC_172 obj = new LC_172();
        System.out.println(obj.trailingZeroes(5));
    }

    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}
