package org.practice.linkedlist;

public class ReverseLinkedList {
    private ListNode reverseList(ListNode head) {
        // means zero
        if (head == null) {
            return head;
        }
        ListNode temp = head;

        // means at least 2 elements are there
        ListNode prev = null;
        ListNode current = temp;
        ListNode next = current.next;

        while (current != null) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }
        head = prev;
        return head;
    }
}
