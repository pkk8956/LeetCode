package Arrays_and_Strings;

public class LC_1071 {

    //Greatest Common Divisor of Strings

    /*For two strings s and t, we say "t divides s" if and only if s = t + ... + t (t concatenated with itself one or more times).
    Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.*/

    public static void main(String[] args) {
        LC_1071 obj = new LC_1071();
        String str1 = "ABCABC", str2 = "ABC";
        System.out.println(obj.gcdOfStrings(str1, str2));
    }

    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";
        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    
}
