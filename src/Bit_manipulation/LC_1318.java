package Bit_manipulation;

public class LC_1318 {

    //Minimum Flips to Make a OR b Equal to c

    /*Given 3 positive integers a, b and c.
    Return the minimum flips required in some bits of a and b to make (a OR b == c). (bitwise OR operation).
    A flip operation consists of changing a single bit 1 to 0 or changing a single bit 0 to 1 in their binary representation.*/

    public static void main(String[] args) {
        LC_1318 obj = new LC_1318();
        int a = 2, b = 6, c = 5;
        System.out.println(obj.minFlips(a, b, c));
    }


    public int minFlips(int a, int b, int c) {
        int flips = 0;
        for (int i = 0; i < 32; i++) {
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            int bitC = (c >> i) & 1;

            if ((bitA | bitB) != bitC) {
                if (bitC == 0) {
                    flips += bitA + bitB; 
                } else {
                    flips += 1;
                }
            }
        }
        return flips;
    }
    
}
