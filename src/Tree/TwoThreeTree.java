package Tree;

public class TwoThreeTree {

    private class Node {
        int[] keys = new int[3];
        Node[] children = new Node[4];
        int keyCount;
        boolean leaf = true;
    }

    private Node root;

    public void insert(int key) {
        if (root == null) {
            root = new Node();
            root.keys[0] = key;
            root.keyCount = 1;
            return;
        }

        Node newRoot = insert(root, key);
        if (newRoot != null) root = newRoot;
    }

    private Node insert(Node node, int key) {
        if (node.leaf) {
            insertKey(node, key);
        } else {
            int idx = childIndex(node, key);
            Node split = insert(node.children[idx], key);
            if (split != null) {
                insertChild(node, split);
            }
        }

        if (node.keyCount == 3) return split(node);
        return null;
    }

    private void insertKey(Node node, int key) {
        int i = node.keyCount - 1;
        while (i >= 0 && key < node.keys[i]) {
            node.keys[i + 1] = node.keys[i];
            i--;
        }
        node.keys[i + 1] = key;
        node.keyCount++;
    }

    private void insertChild(Node node, Node child) {
        int key = child.keys[1];
        int i = node.keyCount - 1;

        while (i >= 0 && key < node.keys[i]) {
            node.keys[i + 1] = node.keys[i];
            node.children[i + 2] = node.children[i + 1];
            i--;
        }

        node.keys[i + 1] = key;
        node.children[i + 1] = child.children[0];
        node.children[i + 2] = child.children[1];
        node.keyCount++;
    }

    private Node split(Node node) {
        Node left = new Node();
        Node right = new Node();

        left.keys[0] = node.keys[0];
        right.keys[0] = node.keys[2];

        left.keyCount = 1;
        right.keyCount = 1;

        left.leaf = node.leaf;
        right.leaf = node.leaf;

        if (!node.leaf) {
            left.children[0] = node.children[0];
            left.children[1] = node.children[1];
            right.children[0] = node.children[2];
            right.children[1] = node.children[3];
        }

        Node parent = new Node();
        parent.keys[0] = node.keys[1];
        parent.children[0] = left;
        parent.children[1] = right;
        parent.keyCount = 1;
        parent.leaf = false;

        return parent;
    }

    private int childIndex(Node node, int key) {
        if (node.keyCount == 1) {
            return key < node.keys[0] ? 0 : 1;
        }
        if (key < node.keys[0]) return 0;
        if (key < node.keys[1]) return 1;
        return 2;
    }

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node node) {
        if (node == null) return;

        if (node.keyCount == 1) {
            if (!node.leaf) inorder(node.children[0]);
            System.out.print(node.keys[0] + " ");
            if (!node.leaf) inorder(node.children[1]);
        } else {
            if (!node.leaf) inorder(node.children[0]);
            System.out.print(node.keys[0] + " ");
            if (!node.leaf) inorder(node.children[1]);
            System.out.print(node.keys[1] + " ");
            if (!node.leaf) inorder(node.children[2]);
        }
    }
}
