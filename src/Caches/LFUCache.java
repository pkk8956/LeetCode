package Caches;

import java.util.*;

public class LFUCache {

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        System.out.println(lfuCache.get(1));
        lfuCache.put(3, 3);
        System.out.println(lfuCache.get(2));
        lfuCache.put(4, 4);
        System.out.println(lfuCache.get(1)); 
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));
    }

    //Least Frequently Used (LFU) Cache

    private static class Node {
        int key;
        int value;
        int freq;
        long time;
        Node(int k, int v, long t) {
            key = k;
            value = v;
            freq = 1;
            time = t;
        }
    }

    private final int capacity;
    private long timestamp = 0;
    private final Map<Integer, Node> map;
    private final PriorityQueue<Node> pq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a.freq != b.freq) return a.freq - b.freq;
                    return Long.compare(a.time, b.time);
                }
        );
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node n = map.get(key);
        pq.remove(n);
        n.freq++;
        n.time = ++timestamp;
        pq.add(n);
        return n.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (map.containsKey(key)) {
            Node n = map.get(key);
            pq.remove(n);
            n.value = value;
            n.freq++;
            n.time = ++timestamp;
            pq.add(n);
            return;
        }

        if (map.size() == capacity) {
            Node least = pq.poll();
            map.remove(least.key);
        }

        Node n = new Node(key, value, ++timestamp);
        map.put(key, n);
        pq.add(n);
    }
}
