package org.practice.linkedlist;

public class NodeAtGivenIndex {
    private ListNode getNodeAt(ListNode head, int index) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

}
