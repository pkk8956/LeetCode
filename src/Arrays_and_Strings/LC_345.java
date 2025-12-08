package Arrays_and_Strings;

public class LC_345 {

    //Reverse Vowels of a String

    /*Given a string s, reverse only all the vowels in the string and return it. The vowels are 
    'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.*/       
    
    public static void main(String[] args) {
        LC_345 obj = new LC_345();
        String s = "hello";
        System.out.println(obj.reverseVowels(s));
    }
 
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            while (left < right && !isVowel(arr[left])) left++;
            while (left < right && !isVowel(arr[right])) right--;
            if (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return new String(arr);
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
