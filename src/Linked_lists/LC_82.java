package Linked_lists;

public class LC_82 {

    //Remove Duplicates from Sorted List II

    /*Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
     leaving only distinct numbers from the original list. Return the linked list sorted as well. */

    public static void main(String[] args) {
        LC_82 obj = new LC_82();  
        ListNode head = new ListNode(1, 
                        new ListNode(2, 
                        new ListNode(3, 
                        new ListNode(3, 
                        new ListNode(4,
                        new ListNode(4,
                        new ListNode(5)))))));
        obj.printListNode(obj.deleteDuplicates(head));
    }

     public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            boolean duplicated = false;
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
                duplicated = true;
            }
            
            if (duplicated) prev.next = curr.next;
            else prev = prev.next;
            curr = curr.next;
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
