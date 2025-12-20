package Two_Pointers;

public class LC_125 {

    //Valid Palindrome

    /*Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
    Note: For the purpose of this problem, we define empty string as valid palindrome.*/

    public static void main(String[] args) {
        LC_125 obj = new LC_125();
        String s = "A man, a plan, a canal: Panama";
        boolean result = obj.isPalindrome(s);       
        System.out.println(result);
    }

    public boolean isPalindrome(String s) {
        //Two Pointers Approach
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            //Move the left pointer to the right until we find an alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            //Move the right pointer to the left until we find an alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            //Compare the characters at the left and right pointers
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}