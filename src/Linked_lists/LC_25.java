package Linked_lists;

public class LC_25 {

    //Reverse Nodes in k-Group

    /*Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
    k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is 
    not a multiple of k then left-out nodes, in the end, should remain as it is.
    You may not alter the values in the list's nodes, only nodes themselves may be changed.*/

    public static void main(String[] args) {
        LC_25 obj = new LC_25();  
        ListNode head = new ListNode(1, 
                        new ListNode(2, 
                        new ListNode(3, 
                        new ListNode(4,
                        new ListNode(5)))));
        obj.printListNode(obj.reverseKGroup(head, 2));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode node = head;
        for (int i = 0; i < k; i++) {
            if (node == null) return head;
            node = node.next;
        }

        ListNode newHead = reverse(head, node);

        head.next = reverseKGroup(node, k);
        return newHead;
    }

    private ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = end;
        while (start != end) {
            ListNode next = start.next;
            start.next = prev;
            prev = start;
            start = next;
        }
        return prev;
    }

    public void printListNode(ListNode listNode){
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

}
