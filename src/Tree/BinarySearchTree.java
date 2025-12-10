package Tree;

public class BinarySearchTree {

    private Node root;

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
}
    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node node, int value) {
        if (node == null) return new Node(value);
        if (value < node.value) node.left = insertRecursive(node.left, value);
        else if (value > node.value) node.right = insertRecursive(node.right, value);
        return node;
    }

    public boolean search(int value) {
        return searchRecursive(root, value);
    }

    private boolean searchRecursive(Node node, int value) {
        if (node == null) return false;
        if (value == node.value) return true;
        return value < node.value ? searchRecursive(node.left, value) : searchRecursive(node.right, value);
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node node, int value) {
        if (node == null) return null;
        if (value < node.value) node.left = deleteRecursive(node.left, value);
        else if (value > node.value) node.right = deleteRecursive(node.right, value);
        else {
            if (node.left == null && node.right == null) return null;
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            int minValue = findMin(node.right);
            node.value = minValue;
            node.right = deleteRecursive(node.right, minValue);
        }

        return node;
    }

    private int findMin(Node node) {
        return node.left == null ? node.value : findMin(node.left);
    }

    public void inorder() {
        inorderRecursive(root);
        System.out.println();
    }

    private void inorderRecursive(Node node) {
        if (node != null) {
            inorderRecursive(node.left);
            System.out.print(node.value + " ");
            inorderRecursive(node.right);
        }
    }
}
