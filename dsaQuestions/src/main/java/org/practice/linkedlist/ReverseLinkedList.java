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


    public ListNode reverseListV2(ListNode head) {

        if(head==null || head.next == null){
            return head;
        }
        ListNode prev = null ;
        ListNode current = head;

        while(current!=null){
            //important step, since here we are destroying and creating the object again and again
            ListNode next = current.next;
            current.next = prev;
            prev=current;
            current = next ;
        }

        head = prev;
        return head;
    }


    public static ListNode reverseListRecursive(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode last = reverseListRecursive(head.next);
        head.next.next=head;
        head.next=null;
        return last;
    }
}
