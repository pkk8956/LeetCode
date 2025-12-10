package Tree;

public class LC_700 {

    // Search in a Binary Search Tree

    /*You are given the root of a binary search tree (BST) and an integer val.
    Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
    If such a node does not exist, return null.*/

    public static void main(String[] args) {
        LC_700 obj = new LC_700();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        int val = 2;
        TreeNode resultNode = obj.searchBST(root, val);
        obj.printTree(resultNode);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;

        if (val < root.val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }

    public void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
    
}
