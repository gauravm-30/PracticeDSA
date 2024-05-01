package org.practice.linkedlist;

public class CircularLinkedList {
  // Circular can be of two types i.e. single circular/double circular

  // Using the single LinkedList  will be using the circular one.
  // here next will be never null .It will be only null if list is empty;
  // so we need to use the either Node tail
  // or we can use the do... while loop
  Node head;
  Node tail;

  private class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }

    public Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }
  }
  // In Circular inserting at first or last is same
  public void insertAtFirstLast(int data) {
    Node newNode = new Node(data);

    if (head == null) {
      head = newNode;
      tail = head;
      tail.next = head;
      return;
    }
    tail.next = newNode;
    newNode.next = head;
    tail = newNode;
    // OR using head
    // newNode.next=head;
    //      head=newNode
    //      tail.next=head;
  }

  public void displayList() {
    Node temp = head;
    if (temp != null) {
      do {
        System.out.println(temp.data);
        temp = temp.next;
      } while (temp != head);
    }
  }

  public void deleteFirst() {
    // check first if list is empty or not.
    // check if there exists only one element
    if (head == null) {
      return;
    }
    // means only one element is there
    if (head == tail) {
      head = null;
      tail = null;
      return;
    }
    // otherwise minimum two elements are present .
    head = head.next;
  }

  public void deleteLast() {
    // check first if list is empty or not.

    // check if there exists only one element

    // otherwise minimum two elements are present

  }

  public void delete(int value) {
    //    check first if list is empty or not.
    // Then check if it is first element ,call delete first()
    //    //if it is the last element, call deleteLast()
    // else follow the given logic
  }
}
