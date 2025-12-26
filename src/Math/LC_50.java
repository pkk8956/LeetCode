package Math;

public class LC_50 {

    //Pow(x, n)

    /*Implement pow(x, n), which calculates x raised to the power n (i.e., xn). */

    public static void main(String[] args) {
        LC_50 obj = new LC_50();
        double x = 4;
        int n = 5;
        System.out.println(obj.myPow(x, n));
    }

    public double myPow(double x, int n) {
        long power = n;

        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        double result = 1.0;

        while (power > 0) {
            if ((power & 1) == 1) {
                result *= x;
            }
            x *= x;
            power >>= 1;
        }

        return result;
    }
    
}
