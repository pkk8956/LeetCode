package Tree;

public class LC_1372 {

    //Longest ZigZag Path in a Binary Tree

    /*Given a binary tree root, a ZigZag path for a binary tree is defined as follows:
    Choose any node in the binary tree and a direction (right or left).
    If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
    Change the direction from right to left or from left to right.
    Repeat the second and third steps until you can't move in the tree.
    A ZigZag path's length is defined as the number of nodes visited - 1. (A single node has a length of 0).
    Return the longest ZigZag path contained in that tree.*/

    public static void main(String[] args) {
        LC_1372 obj = new LC_1372();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.left.right = new TreeNode(1);
        root.right.left.right.left = new TreeNode(1);
        root.right.left.right.left.right = new TreeNode(1);

        System.out.println(obj.longestZigZag(root));
    }

    public int longestZigZag(TreeNode root) {
        int[] max = new int[1];
        dfs(root, max);
        return max[0];
    }

    private int[] dfs(TreeNode node, int[] max) {
        if (node == null) return new int[]{-1, -1}; 

        int[] left = dfs(node.left, max);
        int[] right = dfs(node.right, max);

        int leftZig = left[1] + 1; 
        int rightZig = right[0] + 1; 

        max[0] = Math.max(max[0], Math.max(leftZig, rightZig));

        return new int[]{leftZig, rightZig};
    }
}
