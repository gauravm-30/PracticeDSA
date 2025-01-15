package org.practice.linkedlist;

public class ReverseInBetweenLinkedList {
    private ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        if (left == right) {
            return head;
        }
        // skip the left-1 nodes
        ListNode current = head;
        ListNode prev = null;
        for (int i = 0; current != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }
        ListNode last = prev; // (left-1)th node
        ListNode newEnd = current;
        ListNode next = current.next;
        // reverse between left and right
        for (int i = 0; current != null && i < (right - left) + 1; i++) {
            // reverse the list
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }
        // once reversed previous will be at 'right' index
        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }
        newEnd.next = current;
        return head;
    }

}
