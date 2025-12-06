package Binary_tree;

public class LC_543 {

    //Diameter of Binary Tree

    /*Given the root of a binary tree, return the length of the diameter of the tree. 
    The diameter of a binary tree is the length of the longest path between any two nodes 
    in a tree. This path may or may not pass through the root.
    The length of a path between two nodes is represented by the number of edges between them.*/

    public static void main(String[] args) {
        LC_543 obj = new LC_543();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(obj.diameterOfBinaryTree(root));

    }

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;

        int left = depth(node.left);
        int right = depth(node.right);

        diameter = Math.max(diameter, left + right);

        return Math.max(left, right) + 1;
    }
}