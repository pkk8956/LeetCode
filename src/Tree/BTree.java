package Tree;

public class BTree {

    private static class Node {
        int[] keys;
        Node[] children;
        int n;
        boolean leaf;

        Node(int t, boolean leaf) {
            this.leaf = leaf;
            this.keys = new int[2 * t - 1];
            this.children = new Node[2 * t];
            this.n = 0;
        }
    }

    private Node root;
    private final int t;

    public BTree(int t) {
        this.t = t;
        root = new Node(t, true);
    }

    public boolean search(int key) {
        return searchRecursive(root, key);
    }

    private boolean searchRecursive(Node node, int key) {
        int i = 0;
        while (i < node.n && key > node.keys[i]) i++;

        if (i < node.n && key == node.keys[i]) return true;

        if (node.leaf) return false;

        return searchRecursive(node.children[i], key);
    }

    public void insert(int key) {
        Node r = root;
        if (r.n == 2 * t - 1) {
            Node s = new Node(t, false);
            s.children[0] = r;
            root = s;
            splitChild(s, 0, r);
            insertNonFull(s, key);
        } else {
            insertNonFull(r, key);
        }
    }

    private void insertNonFull(Node node, int key) {
        int i = node.n - 1;

        if (node.leaf) {
            while (i >= 0 && key < node.keys[i]) {
                node.keys[i + 1] = node.keys[i];
                i--;
            }
            node.keys[i + 1] = key;
            node.n++;
        } else {
            while (i >= 0 && key < node.keys[i]) i--;

            i++;

            if (node.children[i].n == 2 * t - 1) {
                splitChild(node, i, node.children[i]);
                if (key > node.keys[i]) i++;
            }

            insertNonFull(node.children[i], key);
        }
    }

    private void splitChild(Node parent, int index, Node fullChild) {
        Node newNode = new Node(t, fullChild.leaf);
        newNode.n = t - 1;

        for (int j = 0; j < t - 1; j++) {
            newNode.keys[j] = fullChild.keys[j + t];
        }

        if (!fullChild.leaf) {
            for (int j = 0; j < t; j++) {
                newNode.children[j] = fullChild.children[j + t];
            }
        }

        fullChild.n = t - 1;

        for (int j = parent.n; j >= index + 1; j--) {
            parent.children[j + 1] = parent.children[j];
        }
        parent.children[index + 1] = newNode;

        for (int j = parent.n - 1; j >= index; j--) {
            parent.keys[j + 1] = parent.keys[j];
        }
        parent.keys[index] = fullChild.keys[t - 1];

        parent.n++;
    }

    public void print() {
        printRecursive(root, 0);
        System.out.println();
    }

    private void printRecursive(Node node, int level) {
        System.out.print("level " + level + ": ");
        for (int i = 0; i < node.n; i++) {
            System.out.print(node.keys[i] + " ");
        }
        System.out.println();
        if (!node.leaf) {
            for (int i = 0; i <= node.n; i++) {
                printRecursive(node.children[i], level + 1);
            }
        }
    }
}
