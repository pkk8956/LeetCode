package Tree;

public class LC_226 {

    //Invert Binary Tree

    /*Given the root of a binary tree, invert the tree, and return its root.*/

    public static void main(String[] args) {
        LC_226 obj = new LC_226();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        obj.printTree(obj.invertTree(root));

    }

    public TreeNode invertTree(TreeNode root) {
         if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}