package org.practice.linkedlist;

public class NthNodeFromEnd {
    // Approach 1
    /*
     *1.First find the length of the linked list.
     *2.Then traverse again for length()-N + 1 times. You will get the nth node from last.
     * 3. TC - O(length()) + O(length()-N)
     * */
    private ListNode getNthNodeFromLastV1(ListNode head, int n) {
        return null;
    }

    // Approach 2
    /*
     *1.Take fast and slow pointers pointing to the head.
     *2.Then move fast pointer by N times.
     *3.Now distance between fast and slow will be always N.
     *4.Now move slow and fast pointer one step each time till fast reaches end.
     *5. Now slow will be pointing to the nth node from last.
     * */
    private ListNode getNthNodeFromLastV2(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        int count = 0;
        while (count < n && fast != null) {
            fast = fast.next;
            count++;
        }
        // At this point fast will be a nth position and slow will be at 1 position.
        // Difference between them is n-1;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // At this point slow have reached at the position at the nth position from end.
        // Now return the slow pointer;
        // also handle the edge cases

        return slow;
    }

}
