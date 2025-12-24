package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LC_103 {

    //Binary Tree Zigzag Level Order Traversal

    /*Given the root of a binary tree, return the zigzag level order traversal of its nodes' 
    values. (i.e., from left to right, then right to left for the next level and alternate between). */

    public static void main(String[] args) {
        LC_103 obj = new LC_103();
        String[] nodes = {"3","9","20","null","null","15","7"};
        TreeNode root =  TreeNode.buildTree(nodes);
        List<List<Integer>> result = obj.zigzagLevelOrder(root);
        for (List<Integer> list : result) System.out.println(list);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // Insert value based on traversal direction
                if (leftToRight) level.add(node.val);
                else level.add(0, node.val);
                // Add children to queue
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(level);
            leftToRight = !leftToRight;
        }

        return result;
    }

    
}
