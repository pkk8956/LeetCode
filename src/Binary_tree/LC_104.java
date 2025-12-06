package Binary_tree;

public class LC_104 {

    //Maximum Depth of Binary Tree

    /*Given the root of a binary tree, return its maximum depth. 
    A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.*/

    public static void main(String[] args) {
        LC_104 obj = new LC_104();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(obj.maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}