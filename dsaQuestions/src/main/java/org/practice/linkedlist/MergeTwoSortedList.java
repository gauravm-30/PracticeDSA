package org.practice.linkedlist;

public class MergeTwoSortedList {
    // merge two sorted Linked Lists
    public static ListNode merge(ListNode list1, ListNode list2) {
        // First create a new ListNode
        ListNode head = new ListNode(); // Node(0,null)
        ListNode temp = head;

        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            }
        }

        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }
        return head.next;
    }
}
