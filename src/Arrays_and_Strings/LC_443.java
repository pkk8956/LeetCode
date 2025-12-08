package Arrays_and_Strings;

public class LC_443 {

    //String Compression

    /*Given an array of characters chars, compress it using the following algorithm:
    Begin with an empty string s. For each group of consecutive repeating characters in chars:
    If the group's length is 1, append the character to s.
    Otherwise, append the character followed by the group's length.
    The compressed string s should not be returned separately, but instead be stored in the input character array chars. 
    Note that group lengths that are 10 or longer will be split into multiple characters in chars.
    After you are done modifying the input array, return the new length of the array.*/

    public static void main(String[] args) {
        LC_443 obj = new LC_443();
        char[] chars = {'a','a','b','b','c','c','c'};
        System.out.println(obj.compress(chars));
    }

    public int compress(char[] chars) {
        int index = 0;
        int i = 0;
        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }
            chars[index++] = currentChar;
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }
        return index;
    }
}
