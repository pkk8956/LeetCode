package Linked_lists;

public class LC_141 {

    //Linked List Cycle

    /*Given head, the head of a linked list, determine if the linked list has a cycle in it.
    There is a cycle in a linked list if there is some node in the list that can be reached again by 
    continuously following the next pointer. Internally, pos is used to denote the index of the node 
    that tail's next pointer is connected to. Note that pos is not passed as a parameter.
    Return true if there is a cycle in the linked list. Otherwise, return false.*/

    public static void main(String[] args) {
        LC_141 obj = new LC_141();  
        ListNode head = new ListNode(3, 
                        new ListNode(2, 
                        new ListNode(0, 
                        new ListNode(-4))));

        System.out.println(obj.hasCycle(head));
    }

   public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;         
            fast = fast.next.next; 
            if (slow == fast) return true;
        }
        return false;
    }

    public void printListNode(ListNode listNode){
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

}
