package org.practice.linkedlist;
// Always need to handle three cases i.e. when it is empty , when  has 1 element , when it has many
// elements
public class SingleLinkedList {
  private Node head;

  // We can create the liked without using the tail and size also
  private Node tail;
  private int size;

  SingleLinkedList() {
    this.size = 0;
  }

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

  public void insertFirst(int data) {
    Node newNode = new Node(data);
    newNode.next = head;
    head = newNode;
    if (tail == null) {
      tail = head;
    }
    size += 1;
  }

  public void insertLast(int data) {

    Node newNode = new Node(data);

    if (tail == null) {
      tail = newNode;
      head = tail;
    }
    tail.next = newNode;
    tail = newNode;
    size += 1;
  }

  public void insertAtV1(int data, int index) {
    Node newNode = new Node(data);
    if (head == null) {
      head = newNode;
      tail = head;
      size += 1;
      return;
    }
    Node temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }
    newNode.next = temp.next;
    temp.next = newNode;
    size += 1;
  }

  public void insertRecursively(int value, int index) {
    head = insertRecursively(value, index, head);
  }

  private Node insertRecursively(int value, int index, Node node) {
    if (index == 0) {
      Node newNode = new Node(value);
      newNode.next = node;
      size++;
      return newNode;
    }

    node.next = insertRecursively(value, index - 1, node.next);
    return node;
  }

  public void insertAtV2(int data, int index) {
    Node newNode = new Node(data);
    if (index == 0) {
      insertFirst(data);
      return;
    }
    if (index == size - 1) {
      insertLast(data);
      return;
    }
    Node temp = head;
    for (int i = 0; i < (index - 1); i++) {
      temp = temp.next;
    }
    newNode.next = temp.next;
    temp.next = newNode;
    size += 1;
  }

  public int deleteFirst() {
    // check first whether list is empty or not
    // and return exception

    int value = head.data;
    head = head.next;
    if (head == null) {
      tail = null;
    }
    size--;
    return value;
  }

  public int deleteLast() {
    // first check whether it is empty or not;
    if (size <= 1) {
      deleteFirst();
    }
    Node temp = get(size - 2); // as Last Index is size-1 and we need to index
    int val = tail.data;
    tail = temp;
    tail.next = null;
    size -= 1;
    return val;
  }

  public int delete(int index) {
    if (index == 0) {
      return deleteFirst();
    }
    if (index == size - 1) {
      return deleteLast();
    }
    Node temp = get(size - 2);
    int value = temp.next.data;
    temp.next = temp.next.next;
    return value;
  }

  public Node find(int value) {
    Node temp = head;
    while (temp != null) {
      if (value == temp.data) {
        return temp;
      }
      temp = temp.next;
    }
    return null;
  }

  public Node get(int index) {
    Node temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }
    return temp;
  }

  public void display() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + "->");
      temp = temp.next;
    }
    System.out.println("End");
  }

  // removeDuplicates from LL
  public Node deleteDuplicates(Node head) {
    // check if 0 or 1 element is there in the Linked List
    if (head == null || head.next == null) {
      return head;
    }
    // OR
    //    if (head == null) { // head.next will get covered  in while loop and at last
    //      return null;
    //    }
    Node temp = head;
    while (temp.next != null) {
      if (temp.data == temp.next.data) {
        temp.next = temp.next.next;
        size--;
      } else {
        temp = temp.next;
      }
    }
    tail = temp;
    tail.next = null;
    return head;
  }

  public static SingleLinkedList merge(SingleLinkedList L1, SingleLinkedList L2) {
    SingleLinkedList l3 = new SingleLinkedList();
    Node first = L1.head;
    Node second = L2.head;
    while (first != null && second != null) {
      if (first.data < second.data) {
        l3.insertLast(first.data);
        first = first.next;
      } else {
        l3.insertLast(second.data);
        second = second.next;
      }
    }

    while (first != null) {
      l3.insertLast(first.data);
      first = first.next;
    }
    while (second != null) {
      l3.insertLast(second.data);
      second = second.next;
    }
    return l3;
  }

  public void bubbleSort() {
    bubbleSortHelper(size - 1, 0);
  }

  public void bubbleSortHelper(int row, int col) {
    if (row == 0) {
      return;
    }

    if (col < row) {
      Node first = get(col);
      Node second = get(col + 1);
      if (first.data > second.data) {
        // swap
        // 3 cases
        if (first == head) {
          first.next = second.next;
          second.next = first;
          head = second;
        } else if (second == tail) {
          Node previous = get(col - 1);
          previous.next = second;
          tail = first;
          first.next = null;
          second.next = tail;
        } else {
          Node previous = get(col - 1);
          previous.next = second;
          first.next = second.next;
          second.next = first;
        }
      }
      bubbleSortHelper(row, col + 1);
    } else {
      bubbleSortHelper(row - 1, 0);
    }
  }

  public void reverseRecursively() {
    reverseRecursivelyHelper(head);
  }

  private void reverseRecursivelyHelper(Node node) {
    if (node == tail) {
      head = tail;
      return;
    }
    reverseRecursivelyHelper(node.next);
    tail.next = node;
    tail = node;
    tail.next = null;
  }
}
