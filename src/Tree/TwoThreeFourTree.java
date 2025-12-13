package Tree;

public class TwoThreeFourTree {

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

        if (root.keyCount == 3) {
            Node newRoot = new Node();
            newRoot.leaf = false;
            newRoot.children[0] = root;
            splitChild(newRoot, 0);
            root = newRoot;
        }

        insertNonFull(root, key);
    }

    private void insertNonFull(Node node, int key) {
        int i = node.keyCount - 1;

        if (node.leaf) {
            while (i >= 0 && key < node.keys[i]) {
                node.keys[i + 1] = node.keys[i];
                i--;
            }
            node.keys[i + 1] = key;
            node.keyCount++;
        } else {
            while (i >= 0 && key < node.keys[i]) i--;
            i++;

            if (node.children[i].keyCount == 3) {
                splitChild(node, i);
                if (key > node.keys[i]) i++;
            }

            insertNonFull(node.children[i], key);
        }
    }

    private void splitChild(Node parent, int index) {
        Node node = parent.children[index];

        Node left = new Node();
        Node right = new Node();

        left.leaf = node.leaf;
        right.leaf = node.leaf;

        left.keys[0] = node.keys[0];
        right.keys[0] = node.keys[2];

        left.keyCount = 1;
        right.keyCount = 1;

        if (!node.leaf) {
            left.children[0] = node.children[0];
            left.children[1] = node.children[1];
            right.children[0] = node.children[2];
            right.children[1] = node.children[3];
        }

        for (int i = parent.keyCount; i > index; i--) {
            parent.keys[i] = parent.keys[i - 1];
            parent.children[i + 1] = parent.children[i];
        }

        parent.keys[index] = node.keys[1];
        parent.children[index] = left;
        parent.children[index + 1] = right;
        parent.keyCount++;
        parent.leaf = false;
    }

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node node) {
        if (node == null) return;

        for (int i = 0; i < node.keyCount; i++) {
            if (!node.leaf) inorder(node.children[i]);
            System.out.print(node.keys[i] + " ");
        }

        if (!node.leaf) inorder(node.children[node.keyCount]);
    }
}
