package Advanced_Data_Structures;

import java.util.Random;

public class SkipList {

    private static final int MAX_LEVEL = 16;
    private static final double P = 0.5;

    private class Node {
        int key;
        Node[] next;

        Node(int key, int level) {
            this.key = key;
            this.next = new Node[level];
        }
    }

    private final Node head = new Node(Integer.MIN_VALUE, MAX_LEVEL);
    private int level = 1;
    private final Random random = new Random();

    public boolean search(int key) {
        Node current = head;

        for (int i = level - 1; i >= 0; i--) {
            while (current.next[i] != null && current.next[i].key < key) {
                current = current.next[i];
            }
        }

        current = current.next[0];
        return current != null && current.key == key;
    }

    public void insert(int key) {
        Node[] update = new Node[MAX_LEVEL];
        Node current = head;

        for (int i = level - 1; i >= 0; i--) {
            while (current.next[i] != null && current.next[i].key < key) {
                current = current.next[i];
            }
            update[i] = current;
        }

        current = current.next[0];
        if (current != null && current.key == key) return;

        int newLevel = randomLevel();

        if (newLevel > level) {
            for (int i = level; i < newLevel; i++) {
                update[i] = head;
            }
            level = newLevel;
        }

        Node newNode = new Node(key, newLevel);

        for (int i = 0; i < newLevel; i++) {
            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }
    }

    public void delete(int key) {
        Node[] update = new Node[MAX_LEVEL];
        Node current = head;

        for (int i = level - 1; i >= 0; i--) {
            while (current.next[i] != null && current.next[i].key < key) {
                current = current.next[i];
            }
            update[i] = current;
        }

        current = current.next[0];

        if (current == null || current.key != key) return;

        for (int i = 0; i < level; i++) {
            if (update[i].next[i] != current) break;
            update[i].next[i] = current.next[i];
        }

        while (level > 1 && head.next[level - 1] == null) {
            level--;
        }
    }

    private int randomLevel() {
        int lvl = 1;
        while (random.nextDouble() < P && lvl < MAX_LEVEL) {
            lvl++;
        }
        return lvl;
    }

    public static void main(String[] args) {
       ;
    }
}
