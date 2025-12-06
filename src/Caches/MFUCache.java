package Caches;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MFUCache {

    public static void main(String[] args) {
        MFUCache mfuCache = new MFUCache(2);
        mfuCache.put(1, 1);
        mfuCache.put(2, 2);
        System.out.println(mfuCache.get(1));
        mfuCache.put(3, 3);
        System.out.println(mfuCache.get(2)); 
        mfuCache.put(4, 4);
        System.out.println(mfuCache.get(1));
        System.out.println(mfuCache.get(3));
        System.out.println(mfuCache.get(4));
    }

    //Most Frequently Used (MFU) Cache

    private static class Node {
        int key;
        int value;
        int freq;
        long timestamp;
        Node(int k, int v, long t) {
            key = k;
            value = v;
            freq = 1;
            timestamp = t;
        }
    }

    private final int capacity;
    private long time = 0;
    private final Map<Integer, Node> map;
    private final PriorityQueue<Node> pq;

    public MFUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a.freq != b.freq) return b.freq - a.freq;
                    return Long.compare(b.timestamp, a.timestamp);
                }
        );
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node n = map.get(key);
        pq.remove(n);
        n.freq++;
        n.timestamp = ++time;
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
            n.timestamp = ++time;
            pq.add(n);
            return;
        }

        if (map.size() == capacity) {
            Node most = pq.poll();
            map.remove(most.key);
        }

        Node n = new Node(key, value, ++time);
        map.put(key, n);
        pq.add(n);
    }
}
