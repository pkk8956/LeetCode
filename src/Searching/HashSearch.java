package Searching;

import java.util.HashMap;

public class HashSearch {

    // Hash Search Algorithm

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();

        map.put("apple", 10);
        map.put("banana", 20);
        map.put("orange", 30);

        String key = "banana";

        if (map.containsKey(key)) {
            System.out.println("Value for " + key + " is " + map.get(key));
        } else {
            System.out.println("Element not found");
        }
    }
}
