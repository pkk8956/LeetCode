package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildTree (String[] nodes) {
        if (nodes == null || nodes.length == 0 || nodes[0].equals("null"))  return null;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < nodes.length) {
            TreeNode current = queue.poll();
            if (!nodes[i].equals("null")) {
            current.left = new TreeNode(Integer.parseInt(nodes[i]));
            queue.offer(current.left);
        }
        i++;
        if (i < nodes.length && !nodes[i].equals("null")) {
            current.right = new TreeNode(Integer.parseInt(nodes[i]));
            queue.offer(current.right);
        }
        i++;
    }
    return root;
    }
}
