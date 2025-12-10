package Tree;

public class LC_450 {

    // Delete Node in a BST

    /*Given a root node reference of a BST and a key, delete the node with the given key in the BST. 
    Return the root node reference (possibly updated) of the BST.*/

    public static void main(String[] args) {
        LC_450 obj = new LC_450();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        int key = 3;
        TreeNode updatedRoot = obj.deleteNode(root, key);
        obj.printTree(updatedRoot);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) root.left = deleteNode(root.left, key);
        else if (key > root.val) root.right = deleteNode(root.right, key);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            TreeNode successor = findMin(root.right);
            root.val = successor.val; 
            root.right = deleteNode(root.right, successor.val); 
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }

    public void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
