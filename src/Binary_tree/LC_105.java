package Binary_tree;

import java.util.HashMap;
import java.util.Map;

public class LC_105 {

    //Construct Binary Tree from Preorder and Inorder Traversal

    /*Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary 
    tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.*/

    public static void main(String[] args) {
        LC_105 obj = new LC_105();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        obj.printTree(obj.buildTree(preorder, inorder));
    }

    private int preorderIndex = 0;
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return new TreeNode();
        for (int i = 0; i < inorder.length; i ++){
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int left, int right){
        if (left > right) return null;
        int rootVal  = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);
        int inorderIndex = inorderMap.get(rootVal);

        root.left = helper(preorder, left, inorderIndex - 1);
        root.right = helper(preorder, inorderIndex + 1, right);

        return root;
    }

    public void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}