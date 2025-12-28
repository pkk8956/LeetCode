package Bit_Manipulation;

public class LC_67 {

    //Add Binary

    /*Given two binary strings a and b, return their sum as a binary string. */

    public static void main(String[] args) {
        LC_67 obj = new LC_67();
        String a = "1010", b = "1011";
        System.out.println(obj.addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';

            sb.append(sum % 2);
            carry = sum / 2;
        }

        return sb.reverse().toString();
    }
    
}
