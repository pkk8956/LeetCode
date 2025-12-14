package Other;

import java.util.Arrays;
import java.util.TreeMap;

public class Indexing {
    public static void main(String[] args) {
        int[] keys = {10, 20, 30, 40, 50};
        String[] values = {"A", "B", "C", "D", "E"};
        int searchKey = 30;

        //Linear search
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == searchKey) {
                System.out.println("Linear search found: " + values[i]);
            }
        }

        //Binary search
        Arrays.sort(keys); 
        int index = Arrays.binarySearch(keys, searchKey);
        if (index >= 0) System.out.println("Binary search found: " + values[index]);

        //TreeMap as a simple B-tree structure for indexing
        TreeMap<Integer, String> indexStructure = new TreeMap<>();
        indexStructure.put(10, "A");
        indexStructure.put(20, "B");
        indexStructure.put(30, "C");
        indexStructure.put(40, "D");
        indexStructure.put(50, "E");

        if (indexStructure.containsKey(searchKey)) {
            System.out.println("TreeMap search found: " + indexStructure.get(searchKey));
        }

        System.out.println("Range search 15-35: " + indexStructure.subMap(15, 36));
    }
}
