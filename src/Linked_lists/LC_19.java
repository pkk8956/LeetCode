package Linked_lists;

public class LC_19 {

    //Remove Nth Node From End of List

    /*Given the head of a linked list, remove the nth node from the end of the list and return its head.*/

    public static void main(String[] args) {
        LC_19 obj = new LC_19();  
        ListNode head = new ListNode(1, 
                        new ListNode(2, 
                        new ListNode(3, 
                        new ListNode(4,
                        new ListNode(5)))));
        obj.printListNode(obj.removeNthFromEnd(head, 2));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

    public void printListNode(ListNode listNode){
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

}
