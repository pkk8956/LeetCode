package Math;

public class LC_69 {

    // Sqrt(x)
 
    /*Given a non-negative integer x, return the square root of x rounded down to 
    the nearest integer. The returned integer should be non-negative as well.
    You must not use any built-in exponent function or operator. */

    public static void main(String[] args) {
        LC_69 obj = new LC_69();
        System.out.println(obj.mySqrt(8));
    }

    public int mySqrt(int x) {
        if (x < 2) return x;

        int low = 1, high = x / 2;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
    
}
