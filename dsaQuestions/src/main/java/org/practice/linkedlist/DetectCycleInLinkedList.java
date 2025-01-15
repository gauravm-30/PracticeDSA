package org.practice.linkedlist;

public class DetectCycleInLinkedList {
    // Whenever cycle question comes in Linked List fast and slow pointer will be used in this case.
    // VVVVI topic detecting cycle
    // Linked list cycle
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // check for first time whether 3 elements exist or not
        //Below condition not required
        if (fast == null || fast.next == null) {
            return false;
        }

        // minimum 3 elements
        while ((fast != null && fast.next != null)) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    // use fast and slow pointer method
    public int lengthOfCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int count = 0;

        // check for first time whether 3 elements exist or not
        if (fast == null || fast.next == null) {
            return count;
        }

        // minimum 3 elements
        while ((fast != null && fast.next != null)) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                count = countInCycle(slow, fast);
                break;
            }
        }

        return count;
    }

    // find start of the cycle
    // Reference from take u forward
    // find the starting point of the loop/cycle in linked list .Multiple approaches
    // Approach 1 Hashtable/hashset can be used
    // Approach 2 Find the meeting point of fast and slow pointer and then make slow pointer point to
    // head and then again move forwared util they meet.
    public ListNode findStartOfCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // making slow pointing to head
                slow = head;
                // traveling again till slow==fast which will give the start of the cycle.
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    private int countInCycle(ListNode slow, ListNode fast) {
        int count = 0;
        do {
            count++;
            slow = slow.next;
        } while (slow != fast);
        return count;
    }

    /*
    * Use Floyd’s Cycle Finding Algorithm (Tortoise and Hare Algorithm) to detect the cycle in the linked list. If the algorithm detects a cycle, it means the list contains one.
  If there is no cycle, the length of the list is simply the number of nodes in the list.
  Find the Length:
  Once you’ve detected the cycle,
  * keep one pointer (let’s call it slow) at the meeting point of the two pointers (where they both meet after detecting the cycle).
  Move another pointer (let’s call it fast)
  * from the meeting point and count the number of nodes until it reaches the meeting point again. This count represents the length of the cycle.
  The total length of the linked list with the cycle is the sum of
  * the length of the cycle and the length of the non-cyclic part of the list.
    * */
    private int lengthOfLinkedListHavingCycle() {
        return -1;
    }
}
