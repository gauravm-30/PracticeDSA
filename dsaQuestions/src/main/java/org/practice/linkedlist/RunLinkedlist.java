package org.practice.linkedlist;

public class RunLinkedlist {
  public static void main(String[] args) {
    SingleLinkedList ll1 = new SingleLinkedList();
    //    ll1.insertFirst(50);
    //    ll1.insertFirst(60);
    //    ll1.insertFirst(70);
    //    ll1.insertFirst(80);
    //    ll1.insertFirst(90);

    ll1.insertLast(50);
    ll1.insertLast(60);
    ll1.insertLast(70);
    ll1.insertLast(80);
    ll1.insertLast(90);
    ll1.insertLast(20);
    ll1.insertLast(25);

    ll1.bubbleSort();
    ll1.display();
  }
}
