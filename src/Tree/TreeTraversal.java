package Tree;

import java.util.*;

public class TreeTraversal {

    public static void dfsPreorder(BinaryTree.Node root) {
        if (root == null) return;
        Stack<BinaryTree.Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTree.Node node = stack.pop();
            System.out.print(node.value + " ");
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        System.out.println();
    }

    public static void dfsInorder(BinaryTree.Node root) {
        if (root == null) return;
        Stack<BinaryTree.Node> stack = new Stack<>();
        BinaryTree.Node current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.value + " ");
            current = current.right;
        }
        System.out.println();
    }

    public static void dfsPostorder(BinaryTree.Node root) {
        if (root == null) return;
        Stack<BinaryTree.Node> stack1 = new Stack<>();
        Stack<BinaryTree.Node> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            BinaryTree.Node node = stack1.pop();
            stack2.push(node);
            if (node.left != null) stack1.push(node.left);
            if (node.right != null) stack1.push(node.right);
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().value + " ");
        }
        System.out.println();
    }

    public static void bfs(BinaryTree.Node root) {
        if (root == null) return;
        Queue<BinaryTree.Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTree.Node node = queue.poll();
            System.out.print(node.value + " ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        System.out.println();
    }
}
