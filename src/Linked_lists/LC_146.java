package Linked_lists;

import java.util.HashMap;

public class LC_146 {

    //LRU Cache

    /*Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
    Implement the LRUCache class:
        - LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
        - int get(int key) Return the value of the key if the key exists, otherwise return -1.
        - void put(int key, int value) Update the value of the key if the key exists. 
            Otherwise, add the key-value pair to the cache. If the number of keys exceeds the 
            capacity from this operation, evict the least recently used key.*/

     public static void main(String[] args) {
        LC_146 obj = new LC_146();
        LRUCache cache = obj.new LRUCache(1);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    class LRUCache {

        private final int capacity;
        private final HashMap<Integer, Node> map;
        private final Node head;
        private final Node tail;


        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        private void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void insertToFront(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }
    
        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            Node node = map.get(key);
            remove(node);
            insertToFront(node);
            return node.value;
        }
    
        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                remove(node);
                insertToFront(node);
                return;
            }

            if (map.size() == capacity) {
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }

            Node newNode = new Node(key, value);
            insertToFront(newNode);
            map.put(key, newNode);
        }
    }
}
