package Binary_tree;

import java.util.*;

public class LC_102 {

    // Binary Tree Level Order Traversal\
    
    /* Given the root of a binary tree, return the level order traversal 
       of its nodes' values. (i.e., from left to right, level by level). */

    public static void main(String[] args) {
        LC_102 obj = new LC_102();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        System.out.println("DFS  : " + obj.levelOrderDFS(root));
        System.out.println("BFS  : " + obj.levelOrderBFS(root));
        System.out.println("Bottom BFS: " + obj.levelOrderBottomBFS(root));
    }

    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        dfs(root, 0, levels);
        return levels;
    }

    private void dfs(TreeNode node, int level, List<List<Integer>> levels) {
        if (node == null) return;
        if (level == levels.size()) levels.add(new ArrayList<>());
        levels.get(level).add(node.val);
        dfs(node.left, level + 1, levels);
        dfs(node.right, level + 1, levels);
    }

    public List<List<Integer>> levelOrderBFS(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(level);
        }
        return result;
    }

     public List<List<Integer>> levelOrderBottomBFS(TreeNode root) {
        if (root == null) return Collections.emptyList();
        LinkedList<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.addFirst(level);
        }

        return result;
    }
}
