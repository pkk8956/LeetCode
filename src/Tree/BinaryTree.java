package Tree;

public class BinaryTree {

    private Node root;

    public class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
}

    public void setRoot(int value) {
        root = new Node(value);
    }

    public Node getRoot() {
        return root;
    }

    public Node addLeft(Node parent, int value) {
        if (parent == null) return null;
        parent.left = new Node(value);
        return parent.left;
    }

    public Node addRight(Node parent, int value) {
        if (parent == null) return null;
        parent.right = new Node(value);
        return parent.right;
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
