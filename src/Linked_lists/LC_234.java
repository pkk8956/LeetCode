package Linked_lists;

public class LC_234 {

    //Palindrome Linked List

    /*Given the head of a singly linked list, return true if it is a palindrome or false otherwise*/

    public static void main(String[] args) {
        LC_234 obj = new LC_234();  
        ListNode head = new ListNode(1, 
                        new ListNode(2, 
                        new ListNode(2, 
                        new ListNode(1))));
        System.out.println(obj.isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverse(slow);

        ListNode p1 = head;
        ListNode p2 = secondHalf;

        while (p2 != null) {
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head;
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
