package Misc;

public class LC_876 {

    //Middle of the Linked List

    /*Given the head of a singly linked list, return the middle node of the linked list.
    If there are two middle nodes, return the second middle node. */

    public static void main(String[] args) {
        LC_876 obj = new LC_876();

    ListNode head = new ListNode(1, 
                    new ListNode(2, 
                    new ListNode(3, 
                    new ListNode(4, 
                    new ListNode(5)))));

        System.out.println(obj.middleNode(head));
    }

    public ListNode middleNode(ListNode head) {

        ListNode firstPointer = head;
        ListNode secondPointer = head;

        while (firstPointer != null && firstPointer.next != null) {
            firstPointer = firstPointer.next.next;
            secondPointer = secondPointer.next;
        }
        return secondPointer;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode current = this;
        while (current != null) {
            sb.append(current.val);
            sb.append(current.next != null ? " -> " : "");
            current = current.next;
        }
        return sb.toString();
    }
 }

