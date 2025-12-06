package Binary_tree;

import java.util.ArrayList;
import java.util.List;

public class LC_199 {

    //Binary Tree Right Side View

    /*Given the root of a binary tree, imagine yourself standing on the right side of it, 
    return the values of the nodes you can see ordered from top to bottom.*/

    public static void main(String[] args) {
        LC_199 obj = new LC_199();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(obj.rightSideView(root));
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, int level, List<Integer> result){
        if (node == null) return;
        if (level == result.size()) result.add(node.val);
        dfs(node.right, level + 1, result);
        dfs(node.left, level + 1, result);
    }
}