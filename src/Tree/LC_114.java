package Tree;

public class LC_114 {

    //Flatten Binary Tree to Linked List

    /*Given the root of a binary tree, flatten the tree into a "linked list":
        - The "linked list" should use the same TreeNode class where the right child pointer 
        points to the next node in the list and the left child pointer is always null.
        - The "linked list" should be in the same order as a pre-order traversal of the binary tree.*/

    public static void main(String[] args) {
        LC_114 obj = new LC_114();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        obj.flatten(root);

        TreeNode curr = root;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.right;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
       curr.right = right;
    }
}