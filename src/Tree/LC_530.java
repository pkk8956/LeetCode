package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC_530 {

    // Minimum Absolute Difference in BST

    /*Given the root of a Binary Search Tree (BST), return the minimum 
    absolute difference between the values of any two different nodes in the tree. */

    public static void main(String[] args) {
        LC_530 obj = new LC_530();
        String[] nodes = {"4","2","6","1","3"};
        System.out.println(obj.getMinimumDifference(TreeNode.buildTree(nodes)));
    }

    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        Integer prev = null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // Traverse left subtree
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            // Compute difference with previous value
            if (prev != null) {
                min = Math.min(min, current.val - prev);
            }
            prev = current.val;

            // Traverse right subtree
            current = current.right;
        }
        return min;
    }
}
