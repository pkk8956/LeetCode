package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LC_637 {

    // Average of Levels in Binary Tree

    /*Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. 
    Answers within 10-5 of the actual answer will be accepted.  */

    public static void main(String[] args) {
        LC_637 obj = new LC_637();
        String[] nodes = {"3","9","20","null","null","15","7"};
        List<Double> result = obj.averageOfLevels(TreeNode.buildTree(nodes));
        System.out.println(result);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                // Add children to queue
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(sum * 1.0 / size);
        }
        return result;
    }
}
