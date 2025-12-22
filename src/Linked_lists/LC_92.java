package Linked_lists;

public class LC_92 {

    //Reverse Linked List II

    /*Given the head of a singly linked list and two integers left 
    and right where left <= right, reverse the nodes of the list 
    from position left to position right, and return the reversed list.*/

    public static void main(String[] args) {
        LC_92 obj = new LC_92();  
        ListNode head = new ListNode(1, 
                        new ListNode(2, 
                        new ListNode(3, 
                        new ListNode(4,
                        new ListNode(5)))));
        int left = 2; int right = 4;
        obj.printListNode(obj.reverseBetween(head, left, right));
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 1; i < left; i++) prev = prev.next;

        ListNode curr = prev.next;

        for (int i = 0; i < right - left; i++) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;
    }

    public void printListNode(ListNode listNode){
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
    
}
