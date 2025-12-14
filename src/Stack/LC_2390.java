package Stack;

public class LC_2390 {

    //Removing Stars From a String

    /*You are given a string s, which contains stars *.
    In one operation, you can:
        -- Choose a star in s.
        -- Remove the closest non-star character to its left, as well as remove the star itself.
    Return the string after all stars have been removed.
    Note:
        -- The input will be generated such that the operation is always possible.
        -- It can be shown that the resulting string will always be unique.*/

    public static void main(String[] args) {
        LC_2390 obj = new LC_2390();
        String s = "leet**cod*e";
        System.out.println(obj.removeStars(s));
    }

    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        int starCount = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '*') {
                starCount++;
            } else {
                if (starCount > 0) {
                    starCount--;
                } else {
                    sb.append(ch);
                }
            }
        }

        return sb.reverse().toString();
    }
    
}
