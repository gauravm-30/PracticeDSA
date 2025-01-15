package org.practice.linkedlist;

// As defined in leetcode
// Definition of single link list
public class ListNode {
    int data;
    ListNode next;

    public ListNode() {} // this will create a ListNode with value 0,null;

    public ListNode(int data) {
        this.data = data;
    }

    public ListNode(int data,ListNode next) {
        this.data = data;
        this.next = next;
    }
}
