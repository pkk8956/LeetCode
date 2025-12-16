package Searching;

class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
        left = right = null;
    }
}

public class TreeSearch {

    // Binary Search Tree Search Algorithm
    
    // Time Complexity: O(h) where h is the height of the tree
    // Space Complexity: O(N) where N is number of nodes in the tree

    Node root;

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) return new Node(value);
        if (value < root.value) root.left = insertRec(root.left, value);
        else if (value > root.value) root.right = insertRec(root.right, value);
        return root;
    }

    public boolean search(int value) {
        Node current = root;
        while (current != null) {
            if (current.value == value) return true;
            current = (value < current.value) ? current.left : current.right;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeSearch tree = new TreeSearch();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);
        tree.insert(9);

        int target = 7;
        if (tree.search(target)) {
            System.out.println("Element " + target + " found in the tree");
        } else {
            System.out.println("Element " + target + " not found in the tree");
        }
    }
}
