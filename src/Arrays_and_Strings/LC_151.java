package Arrays_and_Strings;

public class LC_151 {

    //Reverse Words in a String

    /*Given an input string s, reverse the order of the words. A word is defined as a sequence of non-space characters. 
    The words in s will be separated by at least one space.
    Return a string of the words in reverse order concatenated by a single space.
    Note that s may contain leading or trailing spaces or multiple spaces between two words. 
    The returned string should only have a single space separating the words. Do not include any extra spaces.*/

    public static void main(String[] args) {
        LC_151 obj = new LC_151();
        String s = "  hello world  ";
        System.out.println(obj.reverseWords(s));
    }

    public String reverseWords(String s) {
        char[] str = s.toCharArray();
        reverse(str, 0, str.length - 1);
        int i = 0, idx = 0, n = str.length;
        while (i < n) {
            while (i < n && str[i] == ' ') i++;
            if (i >= n) break;
            if (idx > 0) str[idx++] = ' ';
            int m = idx;
            while (i < n && str[i] != ' ') str[idx++] = str[i++];
            reverse(str, m, idx - 1);
        }
        return new String(str, 0, idx);
    }

    void reverse(char[] str, int i, int j) {
        while (i < j) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
    }
}
