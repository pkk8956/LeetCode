package Tree;

public class RedBlackTree {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        int key;
        Node left, right, parent;
        boolean color;

        Node(int key) {
            this.key = key;
            this.color = RED;
        }
    }

    private Node root;

    public void insert(int key) {
        Node node = new Node(key);
        Node parent = null;
        Node current = root;

        while (current != null) {
            parent = current;
            if (key < current.key) current = current.left;
            else current = current.right;
        }

        node.parent = parent;

        if (parent == null) root = node;
        else if (key < parent.key) parent.left = node;
        else parent.right = node;

        fixInsert(node);
    }

    public void delete(int key) {
        Node node = search(root, key);
        if (node == null) return;

        Node y = node;
        boolean yOriginalColor = y.color;
        Node x;

        if (node.left == null) {
            x = node.right;
            transplant(node, node.right);
        } else if (node.right == null) {
            x = node.left;
            transplant(node, node.left);
        } else {
            y = minimum(node.right);
            yOriginalColor = y.color;
            x = y.right;

            if (y.parent == node) {
                if (x != null) x.parent = y;
            } else {
                transplant(y, y.right);
                y.right = node.right;
                y.right.parent = y;
            }

            transplant(node, y);
            y.left = node.left;
            y.left.parent = y;
            y.color = node.color;
        }

        if (yOriginalColor == BLACK) fixDelete(x);
    }

    private void fixInsert(Node node) {
        while (node != root && node.parent.color == RED) {
            if (node.parent == node.parent.parent.left) {
                Node uncle = node.parent.parent.right;

                if (uncle != null && uncle.color == RED) {
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.right) {
                        node = node.parent;
                        rotateLeft(node);
                    }
                    node.parent.color = BLACK;
                    node.parent.parent.color = RED;
                    rotateRight(node.parent.parent);
                }
            } else {
                Node uncle = node.parent.parent.left;

                if (uncle != null && uncle.color == RED) {
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.left) {
                        node = node.parent;
                        rotateRight(node);
                    }
                    node.parent.color = BLACK;
                    node.parent.parent.color = RED;
                    rotateLeft(node.parent.parent);
                }
            }
        }
        root.color = BLACK;
    }

    private void fixDelete(Node node) {
        while (node != root && colorOf(node) == BLACK) {
            if (node == parentOf(node).left) {
                Node sibling = parentOf(node).right;

                if (colorOf(sibling) == RED) {
                    sibling.color = BLACK;
                    parentOf(node).color = RED;
                    rotateLeft(parentOf(node));
                    sibling = parentOf(node).right;
                }

                if (colorOf(sibling.left) == BLACK && colorOf(sibling.right) == BLACK) {
                    sibling.color = RED;
                    node = parentOf(node);
                } else {
                    if (colorOf(sibling.right) == BLACK) {
                        sibling.left.color = BLACK;
                        sibling.color = RED;
                        rotateRight(sibling);
                        sibling = parentOf(node).right;
                    }
                    sibling.color = parentOf(node).color;
                    parentOf(node).color = BLACK;
                    sibling.right.color = BLACK;
                    rotateLeft(parentOf(node));
                    node = root;
                }
            } else {
                Node sibling = parentOf(node).left;

                if (colorOf(sibling) == RED) {
                    sibling.color = BLACK;
                    parentOf(node).color = RED;
                    rotateRight(parentOf(node));
                    sibling = parentOf(node).left;
                }

                if (colorOf(sibling.left) == BLACK && colorOf(sibling.right) == BLACK) {
                    sibling.color = RED;
                    node = parentOf(node);
                } else {
                    if (colorOf(sibling.left) == BLACK) {
                        sibling.right.color = BLACK;
                        sibling.color = RED;
                        rotateLeft(sibling);
                        sibling = parentOf(node).left;
                    }
                    sibling.color = parentOf(node).color;
                    parentOf(node).color = BLACK;
                    sibling.left.color = BLACK;
                    rotateRight(parentOf(node));
                    node = root;
                }
            }
        }
        if (node != null) node.color = BLACK;
    }

    private void rotateLeft(Node node) {
        Node right = node.right;
        node.right = right.left;

        if (right.left != null) right.left.parent = node;

        right.parent = node.parent;

        if (node.parent == null) root = right;
        else if (node == node.parent.left) node.parent.left = right;
        else node.parent.right = right;

        right.left = node;
        node.parent = right;
    }

    private void rotateRight(Node node) {
        Node left = node.left;
        node.left = left.right;

        if (left.right != null) left.right.parent = node;

        left.parent = node.parent;

        if (node.parent == null) root = left;
        else if (node == node.parent.right) node.parent.right = left;
        else node.parent.left = left;

        left.right = node;
        node.parent = left;
    }

    private void transplant(Node u, Node v) {
        if (u.parent == null) root = v;
        else if (u == u.parent.left) u.parent.left = v;
        else u.parent.right = v;

        if (v != null) v.parent = u.parent;
    }

    private Node minimum(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    private Node search(Node node, int key) {
        while (node != null) {
            if (key == node.key) return node;
            node = key < node.key ? node.left : node.right;
        }
        return null;
    }

    private boolean colorOf(Node node) {
        return node != null && node.color == RED;
    }

    private Node parentOf(Node node) {
        return node == null ? null : node.parent;
    }

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.key + " ");
        inorder(node.right);
    }

}

