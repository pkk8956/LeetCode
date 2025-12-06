package Linked_lists;

public class LC_2 {

    //Add Two Numbers

    /*You are given two non-empty linked lists representing two non-negative integers. The digits are stored
    in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum 
    as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.*/

    public static void main(String[] args) {
        LC_2 obj = new LC_2();  
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        obj.printListNode(obj.addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;

            int sum = v1 + v2 + carry;
            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
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
