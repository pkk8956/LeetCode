package Bit_Manipulation;

public class LC_190 {

    // Reverse Bits

    /*Reverse bits of a given 32 bits signed integer. */

    public static void main(String[] args) {
        LC_190 obj = new LC_190();
        System.out.println(obj.reverseBits(43261596));
    }
    
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32; i++) {
            rev = (rev << 1) | (n & 1);
            n >>>= 1; 
        }
        return rev;
    }
}
