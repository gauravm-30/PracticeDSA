package org.practice.linkedlist;

import java.util.Stack;

public class PalindromeInLinkedList {

    //O(N)
    //SC O(N)
    public boolean isPalindrome(ListNode head) {
        ListNode copyLinkedListHead = null;
        ListNode temp = head;
        while(temp!=null){
            ListNode newNode = new ListNode(temp.data);
            if (copyLinkedListHead != null) {
                newNode.next = copyLinkedListHead;
            }
            copyLinkedListHead = newNode;
            temp = temp.next;
        }

        temp = head ;

        while(temp!=null && copyLinkedListHead!=null){
            if(temp.data!=copyLinkedListHead.data){
                return false;
            }
            temp = temp.next;
            copyLinkedListHead = copyLinkedListHead.next;
        }
        return true;

    }

    //Using Stack
        public boolean isPalindromeV2(ListNode head) {
            Stack<Integer> stack = new Stack();
            ListNode curr = head;
            while(curr != null) {
                stack.push(curr.data);
                curr = curr.next;
            }
            curr = head;
            while(curr != null && curr.data == stack.pop()) {
                curr = curr.next;
            }
            return curr == null;
        }


       //Can you come up with a solution with O(1) space ?
//    But this approach will alter the original linked list structure .

    public static boolean isPalindromeV3(ListNode head){
        if(head==null ||head.next==null){
            return true;
        }
        ListNode tempNode = head;
        ListNode middleNode = getMiddle(head);
        ListNode lastNode = reverseList(middleNode);

        while(lastNode!=null){
            if(tempNode.data!=lastNode.data){
                return false;
            }
            lastNode=lastNode.next;
            tempNode=tempNode.next;
        }
        return true;
    }

    private static ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


}
