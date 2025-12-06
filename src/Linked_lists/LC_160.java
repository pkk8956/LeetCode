package Linked_lists;

public class LC_160 {

    // Intersection of Two Linked Lists

    /*Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. 
    If the two linked lists have no intersection at all, return null.*/

    public static void main(String[] args) {
        LC_160 obj = new LC_160();  
        ListNode headA = new ListNode(4, 
                        new ListNode(1, 
                        new ListNode(8, 
                        new ListNode(4,
                        new ListNode(5)))));
        ListNode headB = new ListNode(5, 
                        new ListNode(6, 
                        new ListNode(1, 
                        new ListNode(8, 
                        new ListNode(4,
                        new ListNode(5))))));
        obj.printListNode(obj.getIntersectionNode(headA, headB));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }

        return pA;
    }

    public void printListNode(ListNode listNode){
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

}
