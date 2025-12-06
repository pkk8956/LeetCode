package Linked_lists;

public class LC_206 {

    // Reverse Linked List

    /*Given the head of a singly linked list, reverse the list, and return the reversed list.*/

    public static void main(String[] args) {
        LC_206 obj = new LC_206();  
        ListNode head = new ListNode(1, 
                        new ListNode(2, 
                        new ListNode(3, 
                        new ListNode(4,
                        new ListNode(5)))));
        obj.printListNode(obj.reverseList(head));
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next; 
            cur.next = prev;          
            prev = cur;               
            cur = next;               
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
