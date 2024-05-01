package org.practice.linkedlist;

public class SortLinkedList {

  public class ListNode {
    int data;
    ListNode next;

    public ListNode() {} // this will create a ListNode with value 0,null;

    public ListNode(int data) {
      this.data = data;
    }

    public ListNode(int data, ListNode next) {
      this.data = data;
      this.next = next;
    }
  }

  // sort the given linked list
  public ListNode mergeSort(ListNode head) {
    if (head == null && head.next == null) {
      return head;
    }
    // geting the mid node  as the fresh list
    ListNode mid = getMid(head);

    ListNode left = mergeSort(head);
    ListNode right = mergeSort(mid);
    return merge(left, right);
  }

  // get middle of node
  ListNode getMid(ListNode head) {
    ListNode midPrevious = null;
    while (head != null && head.next != null) {
      midPrevious = (midPrevious == null) ? head : midPrevious.next;
      head = head.next.next;
    }
    ListNode mid = midPrevious.next;
    // making the mid as the starting element.
    midPrevious.next = null;
    return mid;
  }

  // merge two sorted Linked Lists
  public ListNode merge(ListNode list1, ListNode list2) {
    // First create a new ListNode
    ListNode head = new ListNode(); //  dummy Node(0,null)
    ListNode temp = head;

    while (list1 != null && list2 != null) {
      if (list1.data < list2.data) {
        temp.next = list1;
        list1 = list1.next;
        temp = temp.next;
      } else {
        temp.next = list2;
        list2 = list2.next;
        temp = temp.next;
      }
    }

    if (list1 != null) {
      temp.next = list1;
    } else {
      temp.next = list2;
    }
    return head.next;
  }

  public ListNode bubbleSort(ListNode head) {
    return null;
  }
}
