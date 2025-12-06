package Linked_lists;

public class LC_24 {

    //Swap Nodes in Pairs

    /*Given a linked list, swap every two adjacent nodes and return its head.
     You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)*/

    public static void main(String[] args) {
        LC_24 obj = new LC_24();  
        ListNode head = new ListNode(1, 
                        new ListNode(2, 
                        new ListNode(3, 
                        new ListNode(4,
                        new ListNode(5)))));
        obj.printListNode(obj.swapPairs(head));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode first = head;
        ListNode second = head.next;

        first.next = swapPairs(second.next);
        second.next = first;

        return second;
    }

    public void printListNode(ListNode listNode){
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

}
