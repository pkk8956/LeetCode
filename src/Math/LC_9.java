package Math;

public class LC_9 {

    // Palindrome Number

    /*Given an integer x, return true if x is a Palindrome, and false otherwise. */

    public static void main(String[] args) {
        LC_9 obj = new LC_9();
        System.out.println(obj.isPalindrome(12121));
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        return x == reversedHalf || x == reversedHalf / 10;
    }
}
