package Tree;

import java.util.ArrayList;
import java.util.List;

public class LC_94 {

    //Binary Tree Inorder Traversal

    /*Given the root of a binary tree, return the inorder traversal of its nodes' values.*/

    public static void main(String[] args) {
        LC_94 obj = new LC_94();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(obj.inorderTraversal(root));
        System.out.println(obj.preorderTraversal(root));
        System.out.println(obj.postorderTraversal(root));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, List<Integer> result){
        if (node == null) return;
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        result.add(node.val);          
        preorder(node.left, result);   
        preorder(node.right, result);  
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        postorder(node.left, result); 
        postorder(node.right, result);
        result.add(node.val);
    }
}