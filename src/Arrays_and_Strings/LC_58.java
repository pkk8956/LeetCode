package Arrays_and_Strings;

public class LC_58 {

    // Length of Last Word

    /* Given a string s consisting of words and spaces, return the length of the last word in the string.
    A word is a maximal substring consisting of non-space characters only.*/

    public static void main(String[] args) {
        String s = "Hello World";
        LC_58 obj = new LC_58();
        System.out.println(obj.lengthOfLastWord(s));
    }

    public int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length() - 1;
        // Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') i--;
        // Count the length of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }
        return length;
    }
    
}
