package Caches;                         

import java.util.*;

public class FIFOCache {

     public static void main(String[] args) {
        FIFOCache fifoCache = new FIFOCache(2);
        fifoCache.put(1, 1);
        fifoCache.put(2, 2);
        System.out.println(fifoCache.get(1)); 
        fifoCache.put(3, 3); 
        System.out.println(fifoCache.get(2)); 
        fifoCache.put(4, 4); 
        System.out.println(fifoCache.get(1)); 
        System.out.println(fifoCache.get(3)); 
        System.out.println(fifoCache.get(4)); 
    }

    //First In First Out (FIFO) Cache

    private final int capacity;
    private final Map<Integer, Integer> map;
    private final Queue<Integer> queue;

    public FIFOCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>();
        this.queue = new ArrayDeque<>();
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (!map.containsKey(key)) {
            if (map.size() == capacity) {
                int oldest = queue.poll();
                map.remove(oldest);
            }
            queue.add(key);
        }

        map.put(key, value);
    }
}
