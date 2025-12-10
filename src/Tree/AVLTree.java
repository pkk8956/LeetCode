package Tree;

public class AVLTree {

    private Node root;

    private class Node {
        int value;
        int height;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.height = 1;
        }
    }

    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    private int balance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node t = x.right;

        x.right = y;
        y.left = t;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node t = y.left;

        y.left = x;
        x.right = t;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insertRecursive(node.left, value);
        } else if (value > node.value) {
            node.right = insertRecursive(node.right, value);
        } else {
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = balance(node);

        if (balance > 1 && value < node.left.value) {
            return rightRotate(node);
        }

        if (balance < -1 && value > node.right.value) {
            return leftRotate(node);
        }

        if (balance > 1 && value > node.left.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && value < node.right.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node node, int value) {
        if (node == null) {
            return null;
        }

        if (value < node.value) {
            node.left = deleteRecursive(node.left, value);
        } else if (value > node.value) {
            node.right = deleteRecursive(node.right, value);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left != null) ? node.left : node.right;
            } else {
                Node min = getMin(node.right);
                node.value = min.value;
                node.right = deleteRecursive(node.right, min.value);
            }
        }

        if (node == null) {
            return null;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = balance(node);

        if (balance > 1 && balance(node.left) >= 0) {
            return rightRotate(node);
        }

        if (balance > 1 && balance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && balance(node.right) <= 0) {
            return leftRotate(node);
        }

        if (balance < -1 && balance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private Node getMin(Node node) {
        return node.left == null ? node : getMin(node.left);
    }

    public boolean search(int value) {
        return searchRecursive(root, value);
    }

    private boolean searchRecursive(Node node, int value) {
        if (node == null) {
            return false;
        }

        if (value == node.value) {
            return true;
        }

        return value < node.value
                ? searchRecursive(node.left, value)
                : searchRecursive(node.right, value);
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
