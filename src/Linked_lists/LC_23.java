package Linked_lists;

import java.util.PriorityQueue;

public class LC_23 {

    //Merge k Sorted Lists

    /*You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
    Merge all the linked-lists into one sorted linked-list and return it.*/

    public static void main(String[] args) {
        LC_23 obj = new LC_23();  
        ListNode list1  = new ListNode(1, new ListNode(4,new ListNode(5)));
        ListNode list2  = new ListNode(1, new ListNode(3,new ListNode(4)));
        ListNode list3  = new ListNode(2, new ListNode(6));
        ListNode[] lists = {list1, list2, list3};
        obj.printListNode(obj.mergeKLists(lists));
    }

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode node : lists) {
            if (node != null) pq.add(node);
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            current.next = minNode;
            current = current.next;

            if (minNode.next != null) {
                pq.add(minNode.next);
            }
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
