package org.practice.linkedlist;

// Always need to handle three cases i.e. when it is empty , when  has 1 element , when it has many
// elements
public class DoubleLinkedList {
  private Node head;
  private Node tail;
  private int size;

  private class Node {
    Node prev;
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
    }
  }

  public void insertAtFirst(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = newNode;
      tail = head;
      size++;
      return;
    }
    newNode.next = head;
    head.prev = newNode;
    head = newNode;
    size++;
  }

  public void insertAtLast(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      insertAtFirst(data);
    }
    newNode.prev = tail;
    tail.next = newNode;
    tail = newNode;
    size++;
  }

  public void display() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + "->");
      temp = temp.next;
    }
    System.out.println("End");
  }

  public void displayReverse() {
    Node temp = tail;
    while (temp != null) {
      System.out.print(temp.data + "<-");
      temp = temp.prev;
    }
    System.out.println("End");
  }

  public void insertAtIndex(int afterIndex) {}
}
