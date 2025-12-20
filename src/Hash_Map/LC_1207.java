package Hash_Map;

import java.util.HashMap;
import java.util.HashSet;

public class LC_1207 {

    //Unique Number of Occurrences

    /*Given an array of integers arr, write a function that returns true if and only if 
    the number of occurrences of each value in the array is unique.*/

    public static void main(String[] args) {
        LC_1207 obj = new LC_1207();
        int[] arr = {1,2,2,1,1,3};
        System.out.println(obj.uniqueOccurrences(arr));
    }

    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        HashSet<Integer> occurrencesSet = new HashSet<>();

        for (int freq : frequencyMap.values()) {
            if (occurrencesSet.contains(freq)) {
                return false;
            }
            occurrencesSet.add(freq);
        }

        return true;
    }
    
}
