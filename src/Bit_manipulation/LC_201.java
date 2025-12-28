package Bit_Manipulation;

public class LC_201 {
    
    //Bitwise AND of Numbers Range

    /*Given two integers left and right that represent the range [left, right], 
    return the bitwise AND of all numbers in this range, inclusive. */

    public static void main(String[] args) {
        LC_201 obj = new LC_201();
        System.out.println(obj.rangeBitwiseAnd(5, 7));
    }

    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift;
    }
}
