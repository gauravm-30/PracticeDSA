package org.practice.linkedlist;

public class PairwiseSwapNodes {
    public static ListNode pairwiseSwap(ListNode head){
        //edge cases
        if(head==null || head.next==null){
            return head;
        }
        ListNode prev = null;
        ListNode firstNode = head ;
        while(firstNode!=null && firstNode.next!=null){
            ListNode secondNode = firstNode.next;
            firstNode.next=secondNode.next;
            secondNode.next=firstNode;

            if(prev==null){
                head=secondNode;
            }else {
                prev.next=secondNode;
            }
            prev=firstNode;
            firstNode=firstNode.next;
        }
        return head;
    }
}
