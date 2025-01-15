package org.practice.linkedlist;

public class RemoveDuplicatesFromLinkedList {
    // delete duplicates from linked list
    public ListNode removeDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        while (temp.next != null) {
            if (temp.data == temp.next.data) {
                temp = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

}
