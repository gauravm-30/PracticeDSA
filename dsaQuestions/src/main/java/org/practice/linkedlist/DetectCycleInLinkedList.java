package org.practice.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class DetectCycleInLinkedList {
    // Whenever cycle question comes in Linked List fast and slow pointer will be used in this case.
    // VVVVI topic detecting cycle
    // Linked list cycle
    public boolean hasCycleV1(ListNode head) {
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

    public boolean hasCycleV2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // minimum 3 elements
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    //Using HashSet
    //TC - O(N)
    //SC- O(N)
    public boolean hasCycleV3(ListNode head) {
        ListNode temp = head;
        Set<ListNode> listNodeSet = new HashSet<>();
        while (temp != null ) {
            if (!listNodeSet.contains(temp)) {
                listNodeSet.add(temp);
            }else {
                return true;
            }
            temp = temp.next;

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

    // use fast and slow pointer method
    public int lengthOfCycleV2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean found = false;
        int count = 0;

        // check for first time whether 3 elements exist or not
        // not required to do this
        if (fast == null || fast.next == null) {
            return count;
        }

        // minimum 3 elements
        while ((fast != null && fast.next != null)) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                found=true;
                break;
            }
        }
        if(!found){
            return 0;
        }
        count = countInCycle(slow, fast);
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

// https://www.youtube.com/watch?v=6VRgzaOT2G0&list=PLQ7ZAf76c0ZPVdhV1bAjFv0bQc1xHURzE&index=95
    public ListNode findStartOfCycleV2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean found = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                found=true;
                break;
                // making slow pointing to head
            }
        }

        if(!found){
            return null;
        }

        slow = head;
        // traveling again till slow==fast which will give the start of the cycle.
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
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


    //Why Floyd Cycle Works ?
    // A + B =  (y-2x)L
    //It means covering A + B distance will be equal to doing some loops starting from start of cycle.
    //Since Fast pointer have travelled B distance already in loop ,
    // if it travelled A more distance then ,
    // it will be equal to anyone who started from the starting point of the Cycle and end it there .Hence starting point of the cycle found
    //https://medium.com/swlh/floyds-cycle-detection-algorithm-32881d8eaee1
//    https://cp-algorithms.com/others/tortoise_and_hare.html#why-does-it-work
}
