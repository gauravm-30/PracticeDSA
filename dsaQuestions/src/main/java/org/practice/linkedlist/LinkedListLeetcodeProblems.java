package org.practice.linkedlist;

public class LinkedListLeetcodeProblems {
  // As defined in leetcode
  // Definition of single link list
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

  // delete duplicates from linked list
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode temp = head;
    while (temp != null) {
      if (temp.data == temp.next.data) {
        temp = temp.next.next;
      } else {
        temp = temp.next;
      }
    }
    return head;
  }

  // merge two sorted Linked Lists
  public ListNode merge(ListNode list1, ListNode list2) {
    // First create a new ListNode
    ListNode head = new ListNode(); // Node(0,null)
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

  // Whenever cycle question comes in Linked List fast and slow pointer will be used in this case.
  // VVVVI topic detecting cycle
  // Linked list cycle
  public boolean hasCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    // check for first time whether 3 elements exist or not
    if (fast == null || fast.next == null) {
      return false;
    }

    // minimum 3 elements
    while ((fast != null && fast.next != null)) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }

    return false;
  }

  // use fast and slow pointer method
  public int lengthOfCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    int count = 0;

    // check for first time whether 3 elements exist or not
    if (fast == null || fast.next == null) {
      return count;
    }

    // minimum 3 elements
    while ((fast != null && fast.next != null)) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        count = countInCycle(slow, fast);
        break;
      }
    }

    return count;
  }

  // find start of the cycle
  // Reference from take u forward
  // find the starting point of the loop/cycle in linked list .Multiple approaches
  // Approach 1 Hashtable/hashset can be used
  // Approach 2 Find the meeting point of fast and slow pointer and then make slow pointer point to
  // head and then again move forwared util they meet.
  public ListNode findStartOfCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        // making slow pointing to head
        slow = head;
        // traveling again till slow==fast which will give the start of the cycle.
        while (slow != fast) {
          slow = slow.next;
          fast = fast.next;
        }
        return slow;
      }
    }
    return null;
  }

  // leetcode Happy number
  private boolean isHappy(int n) {
    int slow = n;
    int fast = n;
    do {
      slow = findSquare(slow);
      fast = findSquare(findSquare(fast));
    } while (slow != fast);
    if (slow == 1) {
      return true;
    }
    return false;
  }

  // middle of the linked list
  public ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  private int findSquare(int n) {
    int ans = 0;
    while (n > 0) {
      int rem = n % 10;
      ans += rem * rem;
      n = n / 10;
    }
    return ans;
  }

  private int countInCycle(ListNode slow, ListNode fast) {
    int count = 0;
    do {
      count++;
      slow = slow.next;
    } while (slow != fast);
    return count;
  }

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

  private ListNode reverseBetween(ListNode head, int left, int right) {
    if (head == null) {
      return null;
    }
    if (left == right) {
      return head;
    }
    // skip the left-1 nodes
    ListNode current = head;
    ListNode prev = null;
    for (int i = 0; current != null && i < left - 1; i++) {
      prev = current;
      current = current.next;
    }
    ListNode last = prev; // (left-1)th node
    ListNode newEnd = current;
    ListNode next = current.next;
    // reverse between left and right
    for (int i = 0; current != null && i < (right - left) + 1; i++) {
      // reverse the list
      current.next = prev;
      prev = current;
      current = next;
      if (next != null) {
        next = next.next;
      }
    }
    // once reversed previous will be at 'right' index
    if (last != null) {
      last.next = prev;
    } else {
      head = prev;
    }
    newEnd.next = current;
    return head;
  }

  private ListNode getNodeAt(ListNode head, int index) {
    if (head == null) {
      return null;
    }
    ListNode temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }
    return temp;
  }
}
