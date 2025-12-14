package Linked_lists;

public class LC_2130 {

    //Maximum Twin Sum of a Linked List

    /*In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, 
    if 0 <= i <= (n / 2) - 1.
    For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
    The twin sum is defined as the sum of a node and its twin.
    Given the head of a linked list with even length, return the maximum twin sum of the linked list.*/

    public static void main(String[] args) {
        LC_2130 obj = new LC_2130();
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        int result = obj.pairSum(head);
        System.out.println(result);
    }

    public int pairSum(ListNode head) {
        if(head == null || head.next == null) return 0;

        // Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the linked list
        ListNode prev = null;
        ListNode curr = slow;
        while(curr != null){
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        // Calculate the maximum twin sum
        int maxSum = 0;
        ListNode firstHalf = head;
        ListNode secondHalf = prev;

        while(secondHalf != null){
            maxSum = Math.max(maxSum, firstHalf.val + secondHalf.val);
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return maxSum;
    }
    
}
