package Tree;

public class LC_98 {

    //Validate Binary Search Tree

    /*Given the root of a binary tree, determine if it is a valid binary search tree (BST). A valid BST is defined as follows:
        - The left of a node contains only nodes with keys strictly less than the node's key.
        - The right subtree of a node contains only nodes with keys strictly greater than the node's key.
        - Both the left and right subtrees must also be binary search trees.*/

    public static void main(String[] args) {
        LC_98 obj = new LC_98();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        System.out.println(obj.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode node, long min, long max){
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
    }

}