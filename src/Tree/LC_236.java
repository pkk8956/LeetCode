package Tree;

public class LC_236 {

    //Lowest Common Ancestor of a Binary Tree

    /*Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes 
    p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”*/

    public static void main(String[] args) {
        LC_236 obj = new LC_236();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode p = root.left.left;
        TreeNode q = root.right.right.left;

        TreeNode lca = obj.lowestCommonAncestor(root, p, q);
        System.out.println(lca.val);

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;

        return left != null ? left : right;
    }
}