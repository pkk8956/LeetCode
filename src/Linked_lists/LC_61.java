package Linked_lists;

public class LC_61 {

    //Rotate List

    /*Given the head of a linked list, rotate the list to the right by k places. */

    public static void main(String[] args) {
        LC_61 obj = new LC_61();  
        ListNode head = new ListNode(1, 
                        new ListNode(2, 
                        new ListNode(3, 
                        new ListNode(4,
                        new ListNode(5)))));
        int k = 2;
        obj.printListNode(obj.rotateRight(head, k));
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode curr = head;
        int length = 1;

        while (curr.next != null) {
            curr = curr.next;
            length++;
        }
        curr.next = head;

        k = k % length;
        int stepsToNewTail = length - k;

        ListNode newTail = curr;
        while (stepsToNewTail-- > 0) newTail = newTail.next;

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    public void printListNode(ListNode listNode){
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
    
}
