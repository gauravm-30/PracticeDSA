package org.practice.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class IntersectionPointOfTwoLinkedLists {
    //Brute force method
    //O(n*m)
    public static ListNode intersectionPoint(ListNode headA,ListNode headB){
          ListNode tempA = headA;
          while(tempA!=null){
              //we required here because every time it get reset to null in below loop
              ListNode tempB = headB;
              while(tempB!=null){
                  if(tempA==tempB){
                      return tempA;
                  }
                  tempB= tempB.next;
              }
              tempA=tempA.next;
          }
          return null;
    }

    //Using Hashing Technique
    //O(n+m)
    //SC - O(n)
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> listNode = new HashSet<ListNode>();
        ListNode tempA = headA ;
        while(tempA!=null){
            listNode.add(tempA);
            tempA = tempA.next;
        }
        ListNode tempB  = headB ;
        while(tempB!=null){
            if(listNode.contains(tempB)){
                return tempB;
            }
            tempB = tempB.next ;
        }
        return null ;
    }

    //Using difference count
    //Expected approach
    //O(n+m)
    //Sc - O(1)
    public static ListNode getIntersectionNodeV2(ListNode headA, ListNode headB){
        int lengthA = 0;
        int lengthB = 0;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA!=null){
            lengthA++;
            tempA=tempA.next;
        }
        while(tempB!=null){
            lengthB++;
            tempB=tempB.next;
        }

        int diff = (lengthA>lengthB)?(lengthA-lengthB):(lengthB-lengthA);
        tempA = headA;
        tempB = headB;
        if(lengthA>lengthB){
            while(diff!=0){
                tempA = tempA.next;
                diff--;
            }
        }
        else {
            while (diff!=0){
                tempB=tempB.next;
                diff--;
            }
        }

        while(tempA!=null && tempB!=null){
            if(tempA==tempB){
                return tempA;
            }
            tempA=tempA.next;
            tempB=tempB.next;
        }
        return null;
    }

    //Using two pointer technique
    //Expected approach
    //O(n+m)
    //Sc - O(1)
    public static ListNode getIntersectionNodeV3(ListNode headA, ListNode headB){
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA!=tempB){
            if(tempA==null){
                tempA=headB;
            }else {
                tempA=tempA.next;
            }
            if(tempB==null){
                tempB=headA;
            }else {
                tempB=tempB.next;
            }
        }
        return tempA;
    }

    //Two pointer
    public static ListNode getIntersectionNodeV4(ListNode headA, ListNode headB){
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA!=tempB){
            tempA = (tempA==null)? headB: tempA.next;
            tempB = (tempB==null)? headA: tempB.next;
        }
        return tempA;
    }


    public static void main(String[] args){
    }
}
