package Caches;

import java.util.*;

public class LIFOCache {

    public static void main(String[] args) {
        LIFOCache lifoCache = new LIFOCache(2);
        lifoCache.put(1, 1);
        lifoCache.put(2, 2);
        System.out.println(lifoCache.get(1)); 
        lifoCache.put(3, 3); 
        System.out.println(lifoCache.get(2)); 
        lifoCache.put(4, 4); 
        System.out.println(lifoCache.get(1)); 
        System.out.println(lifoCache.get(3)); 
        System.out.println(lifoCache.get(4)); 
    }

    //Last In First Out (LIFO) Cache

    private final int capacity;
    private final Map<Integer, Integer> map;
    private final Deque<Integer> stack;

    public LIFOCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.stack = new ArrayDeque<>();
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (!map.containsKey(key)) {
            if (map.size() == capacity) {
                int last = stack.pop();
                map.remove(last);
            }
            stack.push(key);
        }

        map.put(key, value);
    }
}
