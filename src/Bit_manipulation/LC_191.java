package Bit_Manipulation;

public class LC_191 {

    // Number of 1 Bits

    /*Given a positive integer n, write a function that returns the number of in 
    its binary representation (also known as the Hamming weight). */

    public static void main(String[] args) {
        LC_191 obj = new LC_191();
        System.out.println(obj.hammingWeight(11));
    }

     public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1); 
            count++;
        }
        return count;
    }
    
}
