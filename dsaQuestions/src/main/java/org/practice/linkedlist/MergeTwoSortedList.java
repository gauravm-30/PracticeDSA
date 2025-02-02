package org.practice.linkedlist;

public class MergeTwoSortedList {
    // merge two sorted Linked Lists
    public static ListNode merge(ListNode list1, ListNode list2) {
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


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Base cases:
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        // Recursive step:
        if (list1.data <= list2.data) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage:
        ListNode list1 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode list2 = new ListNode(2, new ListNode(4, new ListNode(6)));
        ListNode mergedList =mergeTwoLists(list1, list2);

        System.out.print("Merged List: ");
        printList(mergedList); // Output: 1 2 3 4 5 6

        list1 = new ListNode(1);
        list2 = null;
        mergedList = mergeTwoLists(list1, list2);
        System.out.print("Merged List: ");
        printList(mergedList); // Output: 1

        list1 = null;
        list2 = new ListNode(1);
        mergedList =mergeTwoLists(list1, list2);
        System.out.print("Merged List: ");
        printList(mergedList); // Output: 1

        list1 = null;
        list2 = null;
        mergedList = mergeTwoLists(list1, list2);
        System.out.print("Merged List: ");
        printList(mergedList); // Output: (nothing printed as list is empty)
    }
}
