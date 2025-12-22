package Tree;

public class LC_117 {
    
    //Populating Next Right Pointers in Each Node II

    /*Given a binary tree

        struct Node {
        int val;
        Node *left;
        Node *right;
        Node *next;
        }

    Populate each next pointer to point to its next right node. 
    If there is no next right node, the next pointer should be set to NULL.
    Initially, all next pointers are set to NULL.*/

    public static void main(String[] args) {
        LC_117 obj = new LC_117();
        Node root = obj.new Node(1);
        root.left = obj.new Node(2);
        root.right = obj.new Node(3);
        root.left.left = obj.new Node(4);
        root.left.right = obj.new Node(5);
        root.right.right = obj.new Node(7);
        obj.printTree(obj.connect(root));
    }

    public Node connect(Node root) {
        Node curr = root;
        while (curr != null) {
            Node dummy = new Node(0);
            Node tail = dummy;

            while (curr != null) {
                if (curr.left != null) {
                    tail.next = curr.left;
                    tail = tail.next;
                }
                if (curr.right != null) {
                    tail.next = curr.right;
                    tail = tail.next;
                }
                curr = curr.next;
            }
            curr = dummy.next;
        }
        return root;
    }

    public void printTree(Node root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
