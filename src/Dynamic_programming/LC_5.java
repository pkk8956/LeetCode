package Dynamic_Programming;

public class LC_5 {

    //Longest Palindromic Substring

    /*Given a string s, return the longest palindromic substring in s.*/

    public static void main(String[] args) {
        LC_5 obj = new LC_5();  
            
        System.out.println(obj.longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return s;

        //add # between each symbol
        StringBuilder t = new StringBuilder("#");
        for (char c : s.toCharArray()) {
            t.append(c).append('#');
        }
        String str = t.toString();
        int n = str.length();

        int[] p = new int[n]; // palindromic r
        int center = 0, right = 0;
        int maxLen = 0, centerIndex = 0;

        for (int i = 0; i < n; i++) {
            int mirror = 2 * center - i; 

            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            int a = i + p[i] + 1;
            int b = i - p[i] - 1;
            while (a < n && b >= 0 && str.charAt(a) == str.charAt(b)) {
                p[i]++;
                a++;
                b--;
            }

            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }

        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }
}
