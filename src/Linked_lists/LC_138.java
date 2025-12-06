package Linked_lists;

public class LC_138 {

    //Copy List with Random Pointer

    /*A linked list of length n is given such that each node contains an additional random 
    pointer, which could point to any node in the list, or null.
    Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, 
    where each new node has its value set to the value of its corresponding original node. 
    Both the next and random pointer of the new nodes should point to new nodes in the copied list 
    such that the pointers in the original list and copied list represent the same list state. None 
    of the pointers in the new list should point to nodes in the original list.
    For example, if there are two nodes X and Y in the original list, where X.random --> Y, 
    then for the corresponding two nodes x and y in the copied list, x.random --> y.eturn the head of the copied linked list.
    The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
        - val: an integer representing Node.val
        - random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
    Your code will only be given the head of the original linked list. */

    public static void main(String[] args) {
        LC_138 obj = new LC_138();  

        NodeR head = new NodeR(7);
        NodeR n1 = new NodeR(13);
        NodeR n2 = new NodeR(11);
        NodeR n3 = new NodeR(10);
        NodeR n4 = new NodeR(1);

        head.next = n1; n1.next = n2; n2.next = n3; n3.next = n4;

        head.random = null;
        n1.random = head;
        n2.random = n4;
        n3.random = n2;
        n4.random = head;

        obj.printNode(obj.copyRandomList(head));
    }

    public NodeR copyRandomList(NodeR head) {
        if (head == null) return null;

        // 1) Insert cloned nodes between original nodes
        //A.next = A'
        //A'.next = B
        //B.next = B'
        NodeR cur = head;
        while (cur != null) {
            NodeR copy = new NodeR(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }

        // 2) Assign random pointers for copied nodes
        cur = head;
        while (cur != null) {
            if (cur.random != null) cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        // 3) Separate original list and copied list
        NodeR dummy = head.next;
        cur = head;
        while (cur != null) {
            NodeR copy = cur.next;
            cur.next = copy.next;
            if (copy.next != null) copy.next = copy.next.next;
            cur = cur.next;
        }

        return dummy;
    }


    public void printNode(NodeR node){
        while (node != null) {
            System.out.print("[" + node.val + ", " + (node.random != null ? node.random.val: "null") + "]");
            node = node.next;
        }
    }
    
}
