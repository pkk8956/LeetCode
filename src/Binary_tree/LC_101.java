package Binary_tree;

public class LC_101 {

    // Symmetric Tree

    /*Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).*/

    public static void main(String[] args) {
        LC_101 obj = new LC_101();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(obj.isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return compare(root.left, root.right);
    }

    private boolean compare (TreeNode left, TreeNode right){
        if (left == null || right == null) return left == right;
        if (left.val != right.val) return false;
        return compare(left.left, right.right) && compare(left.right, right.left);
    }
}