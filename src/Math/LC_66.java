package Math;

public class LC_66 {

    // Plus One

    /* You are given a large integer represented as an integer array digits, where each 
    digits[i] is the ith digit of the integer. The digits are ordered from most significant to 
    least significant in left-to-right order. The large integer does not contain any leading 0's.
    Increment the large integer by one and return the resulting array of digits. */

    public static void main(String[] args) {
        LC_66 obj = new LC_66();
        int[] digits = {4,3,2,1};
        System.out.println(obj.plusOne(digits));

    }

    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        // Если все цифры были 9, создаём новый массив
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}
