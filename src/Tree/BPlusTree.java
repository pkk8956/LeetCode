package Tree;

import java.util.ArrayList;
import java.util.List;

public class BPlusTree {

    private static class Node {
        List<Integer> keys;
        List<Node> children;
        boolean leaf;
        Node next;

        Node(boolean leaf) {
            this.leaf = leaf;
            keys = new ArrayList<>();
            children = new ArrayList<>();
            next = null;
        }
    }

    private Node root;
    private final int t;

    public BPlusTree(int t) {
        this.t = t;
        root = new Node(true);
    }

    public void insert(int key) {
        Node r = root;
        if (r.keys.size() == 2 * t - 1) {
            Node s = new Node(false);
            s.children.add(r);
            root = s;
            splitChild(s, 0, r);
            insertNonFull(s, key);
        } else {
            insertNonFull(r, key);
        }
    }

    private void insertNonFull(Node node, int key) {
        int i = node.keys.size() - 1;

        if (node.leaf) {
            node.keys.add(0);
            while (i >= 0 && key < node.keys.get(i)) {
                node.keys.set(i + 1, node.keys.get(i));
                i--;
            }
            node.keys.set(i + 1, key);
        } else {
            while (i >= 0 && key < node.keys.get(i)) i--;
            i++;
            if (node.children.get(i).keys.size() == 2 * t - 1) {
                splitChild(node, i, node.children.get(i));
                if (key > node.keys.get(i)) i++;
            }
            insertNonFull(node.children.get(i), key);
        }
    }

    private void splitChild(Node parent, int index, Node fullChild) {
        Node newNode = new Node(fullChild.leaf);
        int mid = t;

        for (int j = mid; j < fullChild.keys.size(); j++) {
            newNode.keys.add(fullChild.keys.get(j));
        }
        if (!fullChild.leaf) {
            for (int j = mid; j < fullChild.children.size(); j++) {
                newNode.children.add(fullChild.children.get(j));
            }
        }

        for (int j = fullChild.keys.size() - 1; j >= mid; j--) {
            fullChild.keys.remove(j);
        }
        if (!fullChild.leaf) {
            for (int j = fullChild.children.size() - 1; j >= mid; j--) {
                fullChild.children.remove(j);
            }
        }

        if (fullChild.leaf) {
            newNode.next = fullChild.next;
            fullChild.next = newNode;
        }

        parent.children.add(index + 1, newNode);
        parent.keys.add(index, newNode.keys.get(0));
    }

    public boolean search(int key) {
        return searchRecursive(root, key);
    }

    private boolean searchRecursive(Node node, int key) {
        int i = 0;
        while (i < node.keys.size() && key >= node.keys.get(i)) i++;
        if (node.leaf) {
            for (int k : node.keys) {
                if (k == key) return true;
            }
            return false;
        } else {
            return searchRecursive(node.children.get(i), key);
        }
    }

    public void print() {
        printRecursive(root, 0);
        System.out.println();
    }

    private void printRecursive(Node node, int level) {
        System.out.print("Level " + level + ": ");
        for (int k : node.keys) {
            System.out.print(k + " ");
        }
        System.out.println();
        if (!node.leaf) {
            for (Node child : node.children) {
                printRecursive(child, level + 1);
            }
        }
    }
}
