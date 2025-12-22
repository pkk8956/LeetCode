package Tree;

import java.util.ArrayDeque;

public class LC_173 {

    //Binary Search Tree Iterator

    /*Implement the BSTIterator class that represents an iterator 
    over the in-order traversal of a binary search tree (BST):
        -- BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. 
        The root of the BST is given as part of the constructor. The pointer should be 
        initialized to a non-existent number smaller than any element in the BST.
        -- boolean hasNext() Returns true if there exists a number in 
        the traversal to the right of the pointer, otherwise returns false.
        -- int next() Moves the pointer to the right, then returns the number at the pointer.
    Notice that by initializing the pointer to a non-existent smallest number, 
    the first call to next() will return the smallest element in the BST.
    You may assume that next() calls will always be valid. That is, there will be at 
    least a next number in the in-order traversal when next() is called. */

    public static void main(String[] args) {
        LC_173 obj = new LC_173();
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        BSTIterator bstIterator = obj.new BSTIterator(root);
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
    }

    class BSTIterator {

        private ArrayDeque<TreeNode> stack = new ArrayDeque<>();

        public BSTIterator(TreeNode root) {
            pushLeft(root);
        }
    
        public int next() {
            TreeNode node = stack.pop();
            if (node.right != null) pushLeft(node.right);
            return node.val;
        }
    
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        private void pushLeft(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }
}
