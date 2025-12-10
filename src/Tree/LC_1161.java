package Tree;

public class LC_1161 {

    // Maximum Level Sum of a Binary Tree

    /*Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
    Return the smallest level x such that the sum of all the values of nodes at level x is maximal.*/

    public static void main(String[] args) {
        LC_1161 obj = new LC_1161();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);
        System.out.println(obj.maxLevelSum(root)); 
    }

    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;

        int maxSum = Integer.MIN_VALUE;
        int resultLevel = 1;
        int currentLevel = 1;

        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int currentLevelSum = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevelSum += currentNode.val;
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }

            if (currentLevelSum > maxSum) {
                maxSum = currentLevelSum;
                resultLevel = currentLevel;
            }

            currentLevel++;
        }
        return resultLevel;
    }
}
