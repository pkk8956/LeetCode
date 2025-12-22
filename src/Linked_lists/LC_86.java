package Linked_lists;

public class LC_86 {

    //Partition List

    /*Given the head of a linked list and a value x, partition it such that all 
    nodes less than x come before nodes greater than or equal to x.
    You should preserve the original relative order of the nodes in each of the two partitions. */

    public static void main(String[] args) {
        LC_86 obj = new LC_86();  
        ListNode head = new ListNode(1, 
                        new ListNode(4, 
                        new ListNode(3, 
                        new ListNode(2,
                        new ListNode(5,
                        new ListNode(2))))));
        int x = 3;
        obj.printListNode(obj.partition(head, x));
    }

     public ListNode partition(ListNode head, int x) {
        ListNode lessDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);

        ListNode less = lessDummy;
        ListNode greater = greaterDummy;

        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }

        greater.next = null;
        less.next = greaterDummy.next;

        return lessDummy.next;
    }

    public void printListNode(ListNode listNode){
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
    
}
