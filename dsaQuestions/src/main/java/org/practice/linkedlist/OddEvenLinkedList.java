package org.practice.linkedlist;

public class OddEvenLinkedList {
    public static void main(String[] args){

    }

  // Brute Force
  // Traverse the original list.
  // Create two new lists (or dummy heads for two lists): one for odd-indexed nodes and one for
  // even-indexed nodes.
  // As you traverse the original list, add each node to the appropriate odd or even list.
  // After traversing the original list, connect the tail of the odd list to the head of the even
  // list.
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Nothing to rearrange
        }

        ListNode oddHead = new ListNode(-1); // Dummy head for odd list
        ListNode evenHead = new ListNode(-1); // Dummy head for even list
        ListNode oddTail = oddHead;
        ListNode evenTail = evenHead;

        int position = 1;
        ListNode current = head;

        while (current != null) {
            if (position % 2 != 0) { // Odd position
                oddTail.next = current;
                oddTail = oddTail.next;
            } else { // Even position
                evenTail.next = current;
                evenTail = evenTail.next;
            }
            current = current.next;
            position++;
        }

        oddTail.next = evenHead.next; // Connect odd tail to even head
        evenTail.next = null; // Important: terminate the even list

        return oddHead.next; // Return the head of the rearranged list
    }
    public static ListNode oddEvenLinkedList(ListNode head){

        if(head==null || head.next==null){
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;

        while(odd.next!=null && even.next!=null){
             odd.next = even.next;
             odd = odd.next;
             even.next = odd.next;
             even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
