package Bit_Manipulation;

public class LC_338 {

    //Counting Bits

    /*Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), 
    ans[i] is the number of 1's in the binary representation of i.*/

    public static void main(String[] args) {
        LC_338 obj = new LC_338();
        int n = 5;
        int[] result = obj.countBits(n);
        for (int count : result) {
            System.out.print(count + " ");
        }
    }

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
    
}
