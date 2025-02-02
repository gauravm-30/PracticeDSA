package org.practice.linkedlist;

public class RemoveNthNodeFromEnd {
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return head;
        }

        ListNode first = head ;
        ListNode second = head ;
        ListNode prev = null;
        while(n>0){
            second=second.next;
            n--;
        }

        while(second!=null){
            prev=first;
            first=first.next;
            second=second.next;
        }
        if(prev==null){
            head=head.next;
        }else{
            prev.next = first.next;
            first.next=null;
        }
        return head;
    }



}
