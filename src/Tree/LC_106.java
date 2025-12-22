package Tree;

import java.util.HashMap;
import java.util.Map;

public class LC_106 {

    //Construct Binary Tree from Inorder and Postorder Traversal

    /*Given two integer arrays inorder and postorder where inorder is the inorder traversal of a 
    binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree. */

    public static void main(String[] args) {
        LC_106 obj = new LC_106();
        int[] inorder  = {9,3,15,20,7};
        int[] postorder  = {9,15,7,20,3};
        obj.printTree(obj.buildTree(inorder, postorder));
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return build(inorder, postorder, 0, inorder.length - 1, map, new int[]{postorder.length - 1});
    }

    private TreeNode build(int[] inorder, int[] postorder, int left, int right,
        Map<Integer, Integer> map, int[] postIdx) {
        if (left > right) return null;
        int rootVal = postorder[postIdx[0]--];
        TreeNode root = new TreeNode(rootVal);
        int index = map.get(rootVal);
        root.right = build(inorder, postorder, index + 1, right, map, postIdx);
        root.left  = build(inorder, postorder, left, index - 1, map, postIdx);
        return root;
    }

    public void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
