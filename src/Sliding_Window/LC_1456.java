package Sliding_Window;

public class LC_1456 {

    //Maximum Number of Vowels in a Substring of Given Length

    /*Given a string s and an integer k, return the maximum number of vowels in any substring of s with length k.*/

    public static void main(String[] args) {
        LC_1456 obj = new LC_1456();
        String s = "abciiidef";
        int k = 3;
        System.out.println(obj.maxVowels(s, k));
    }

    public int maxVowels(String s, int k) {
        int left = 0;
        int right = 0;
        int vowelCount = 0;
        int maxVowelCount = 0;

        while (right < s.length()) {
            if (isVowel(s.charAt(right))) {
                vowelCount++;
            }

            if (right - left + 1 > k) {
                if (isVowel(s.charAt(left))) {
                    vowelCount--;
                }
                left++;
            }

            maxVowelCount = Math.max(maxVowelCount, vowelCount);
            right++;
        }

        return maxVowelCount;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}