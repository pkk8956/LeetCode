package Tree;

import java.util.Stack;

public class LC_230 {

    //Kth Smallest Element in a BST

    /*Given the root of a binary search tree, and an integer k, return the kth smallest
    value (1-indexed) of all the values of the nodes in the tree.*/

    public static void main(String[] args) {
        LC_230 obj = new LC_230();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println(obj.kthSmallest(root, 1));
        System.out.println(obj.kthSmallest(root, 1, true));

    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            k--;
            if (k == 0) return node.val;
            node = node.right;
        }
        return -1;
    }

    public int kthSmallest(TreeNode root, int k, boolean isDFS) {
        count = k;
        answer = -1;
        dfs(root);
        return answer;
    }

    private int count;
    private int answer;

    private void dfs(TreeNode node) {
        if (node == null || count == 0) return;
        dfs(node.left);
        count--;
        if (count == 0) {
            answer = node.val;
            return;
        }
        dfs(node.right);
    }
}