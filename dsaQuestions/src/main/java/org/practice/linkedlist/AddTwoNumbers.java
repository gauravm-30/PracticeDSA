package org.practice.linkedlist;

//https://leetcode.com/problems/add-two-numbers/description/
public class AddTwoNumbers {

    //But issue with approach is that it will overflow for int
    //work only if linked list digits are under int
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){

        ListNode temp = l1;

        int firstNumber = 0;
        int placeFactor = 1;
        while (temp!=null){
            firstNumber = firstNumber + placeFactor*temp.data;
            placeFactor = placeFactor*10;
            temp=temp.next;
        }

        //resetting the factor
        placeFactor=1;
        temp=l2;
        int secondNumber = 0;

        while (temp!=null){
            secondNumber = secondNumber + placeFactor*(temp.data);
            placeFactor = placeFactor*10;
            temp=temp.next;
        }

        int sum = firstNumber + secondNumber;

        if(sum==0){
            return l1;  //or return l2
        }

        ListNode resultNode = new ListNode();
        temp=resultNode;

        while(sum > 0){
            int rem = sum%10;
            temp.next=new ListNode(rem);
            sum = sum/10;
            temp=temp.next;
        }
         return resultNode.next;
    }

    public static ListNode addTwoNumbersV2(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode temp = null;
        int carry = 0;
        while(l1!=null || l2!=null || carry!=0){
            int val1 = (l1==null)?0:l1.data;
            int val2 = (l2==null)?0:l2.data;
            int sum = val1 + val2 + carry;
            ListNode newNode = new ListNode(sum%10);
            carry = sum/10;
            if(head==null){
                head = newNode;
                temp = newNode;
            }else{
                temp.next=newNode;
                temp=temp.next;
            }

            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
        }
        return head;
    }

    public static ListNode addTwoNumbersV3(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode temp = head;
        int carry = 0;
        while(l1!=null || l2!=null || carry!=0){
            int val1 = (l1==null)?0:l1.data;
            int val2 = (l2==null)?0:l2.data;
            int sum = val1 + val2 + carry;
            ListNode newNode = new ListNode(sum%10);
            carry = sum/10;
            temp.next=newNode;
            temp=temp.next;
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
        }
        return head.next;
    }
}
