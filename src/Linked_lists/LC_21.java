package Linked_lists;

public class LC_21 {

    //Merge Two Sorted Lists

    /*You are given the heads of two sorted linked lists list1 and list2.
    Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
    Return the head of the merged linked list.*/

    public static void main(String[] args) {
        LC_21 obj = new LC_21();  
        ListNode list1  = new ListNode(1, new ListNode(2,new ListNode(4)));
        ListNode list2  = new ListNode(1, new ListNode(3,new ListNode(4)));
        obj.printListNode(obj.mergeTwoLists(list1, list2));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1); 
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
               current.next = list1;
               list1 = list1.next;
            } else {
               current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) current.next = list1;
        if (list2 != null) current.next = list2;

        return dummy.next;
    }

    public void printListNode(ListNode listNode){
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

}
