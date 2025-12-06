package Stack;

import java.util.ArrayDeque;

public class LC_394 {

    //Decode String

    /*Given an encoded string, return its decoded string. The encoding rule is: k[encoded_string], 
    where the encoded_string inside the square brackets is being repeated exactly k times.
    Note that k is guaranteed to be a positive integer. You may assume that the input 
    string is always valid; there are no extra white spaces, square brackets are well-formed, etc.
    Furthermore, you may assume that the original data does not contain any digits and that 
    digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].*/ 
    
    public static void main(String[] args) {
        LC_394 obj = new LC_394();
        String s = "3[a2[c]]";
        System.out.println(obj.decodeString(s));    
    }

    public String decodeString(String s) {

        ArrayDeque<Integer> countStack = new ArrayDeque<>();
        ArrayDeque<StringBuilder> stringStack = new ArrayDeque<>();
        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(current);
                current = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                int repeat = countStack.pop();
                StringBuilder prev = stringStack.pop();
                while (repeat-- > 0) prev.append(current);
                current = prev;
            } else {
                current.append(ch);
            }
        }
        return current.toString();
    }
}
