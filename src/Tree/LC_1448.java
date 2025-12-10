package Tree;

public class LC_1448 {
    
    //Count Good Nodes in Binary Tree

    /*Given a binary tree root, a node X in the tree is named good if in the path from root to X 
    there are no nodes with a value greater than X. Return the number of good nodes in the binary tree.*/

    public static void main(String[] args) {
        LC_1448 obj = new LC_1448();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.left = new TreeNode(5);
        System.out.println(obj.goodNodes(root));
    }

    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int maxSoFar) {
        if (node == null) return 0;
        int count = 0;
        if (node.val >= maxSoFar) count = 1;
        maxSoFar = Math.max(maxSoFar, node.val);
        count += dfs(node.left, maxSoFar);
        count += dfs(node.right, maxSoFar);
        return count;
    }
}
