package Data_Structure;

public class BSTree<T extends Comparable<T>> {
    private static class Node<T> {
        T value;
        Node<T> left, right;
        Node(T value) { this.value = value; }
    }

    private Node<T> root;

    public void insert(T value) {
        root = insert(root, value);
    }

    private Node<T> insert(Node<T> node, T value) {
        if (node == null) return new Node<>(value);
        if (value.compareTo(node.value) < 0) node.left = insert(node.left, value);
        else if (value.compareTo(node.value) > 0) node.right = insert(node.right, value);
        return node;
    }

    public boolean search(T value) {
        return search(root, value);
    }

    private boolean search(Node<T> node, T value) {
        if (node == null) return false;
        int cmp = value.compareTo(node.value);
        if (cmp == 0) return true;
        return cmp < 0 ? search(node.left, value) : search(node.right, value);
    }

    public void delete(T value) {
        root = delete(root, value);
    }

    private Node<T> delete(Node<T> node, T value) {
        if (node == null) return null;
        int cmp = value.compareTo(node.value);
        if (cmp < 0) node.left = delete(node.left, value);
        else if (cmp > 0) node.right = delete(node.right, value);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node<T> min = findMin(node.right);
            node.value = min.value;
            node.right = delete(node.right, min.value);
        }
        return node;
    }

    private Node<T> findMin(Node<T> node) {
        while (node.left != null) node = node.left;
        return node;
    }

    public void inorderTraversal() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node<T> node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.value + " ");
            inorder(node.right);
        }
    }
}
