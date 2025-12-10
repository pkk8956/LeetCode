package Tree;

import java.util.ArrayList;
import java.util.List;

public class LC_872 {

    // Leaf-Similar Trees

    /*Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
    Two binary trees are considered leaf-similar if their leaf value sequence is the same.
    Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.*/

    public static void main(String[] args) {
        LC_872 obj = new LC_872();
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(2);
        root2.right.right.left = new TreeNode(9);
        root2.right.right.right = new TreeNode(8);
        System.out.println(obj.leafSimilar(root1, root2));
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> l1= new ArrayList<>();
        ArrayList<Integer> l2= new ArrayList<>();
        lstofnodes(root1,l1);
        lstofnodes(root2,l2);
        return l1.equals(l2);

    }
    public void lstofnodes(TreeNode node,List<Integer> lst)
    {
        if(node==null) return;
        if(node.left==null && node.right==null)
        lst.add(node.val);
        lstofnodes(node.left,lst);
        lstofnodes(node.right,lst);
        
    }
}
