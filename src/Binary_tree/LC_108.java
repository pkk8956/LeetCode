package Binary_tree;

public class LC_108 {

    //Convert Sorted Array to Binary Search Tree

    /*Given an integer array nums where the elements are sorted in ascending order, convert it 
    to a height-balanced binary search tree.*/

    public static void main(String[] args) {
        LC_108 obj = new LC_108();

        int[] nums ={-10, -3, 0, 5, 9};
        obj.printTree(obj.sortedArrayToBST(nums));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }
    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = buildTree(nums, left, mid - 1);
        root.right = buildTree(nums, mid + 1, right); 

        return root;
    }

    public void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}