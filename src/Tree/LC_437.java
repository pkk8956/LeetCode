package Tree;

import java.util.HashMap;

public class LC_437 {

    //Path Sum III

    /*Given the root of a binary tree and an integer targetSum, return the number of paths where 
    the sum of the values along the path equals targetSum. The path does not need to start or end 
    at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).*/

    public static void main(String[] args) {
        LC_437 obj = new LC_437();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        root.right.right = new TreeNode(11);
        System.out.println(obj.pathSum(root, 8));

    }

     public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return dfs(root, 0, targetSum, prefix);
    }

    private int dfs(TreeNode node, long currentSum, int targetSum, HashMap<Long, Integer> prefix) {
        if (node == null) return 0;

        currentSum += node.val;
        int count = prefix.getOrDefault(currentSum - targetSum, 0);

        prefix.put(currentSum, prefix.getOrDefault(currentSum, 0) + 1);

        count += dfs(node.left, currentSum, targetSum, prefix);
        count += dfs(node.right, currentSum, targetSum, prefix);

        prefix.put(currentSum, prefix.get(currentSum) - 1);

        return count;
    }
}