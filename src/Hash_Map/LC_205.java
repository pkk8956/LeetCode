package Hash_Map;

public class LC_205 {

    //Isomorphic Strings

    /*Given two strings s and t, determine if they are isomorphic.
    Two strings s and t are isomorphic if the characters in s can be replaced to get t.
    All occurrences of a character must be replaced with another character while preserving the order of characters.
    No two characters may map to the same character, but a character may map to itself.*/

    public static void main(String[] args) {
        LC_205 obj = new LC_205();  
        String s = "egg";
        String t = "add";
        System.out.println(obj.isIsomorphic(s, t));
    }

    public boolean isIsomorphic(String s, String t) {
        //Using two arrays to store the last seen positions of characters
        int[] mapS = new int[256];
        int[] mapT = new int[256];
        //Iterate through both strings
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            //If the last seen positions are different, return false
            if (mapS[charS] != mapT[charT]) return false;

            //Update the last seen positions
            mapS[charS] = i + 1;
            mapT[charT] = i + 1;
        }
        return true;
    }
    
}
