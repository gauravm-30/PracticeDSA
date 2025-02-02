package org.practice.linkedlist;

public class Sort0_1_2LinkedList {
    public static void main(String[] args){
        ListNode input = new ListNode(1,
                new ListNode(2,
                        new ListNode(2,
                                new ListNode(1,
                                        new ListNode(2,
                                                new ListNode(0,
                                                        new ListNode(2,
                                                                new ListNode(2,null))))))));

        ListNode resultNode = segregate(input);
        while(resultNode!=null){
      System.out.print(resultNode.data + " ");
      resultNode=resultNode.next;
    }
  }



    // Function to sort a linked list of 0s, 1s and 2s.
    static ListNode segregate(ListNode head) {
        // add your code here
        ListNode resultHead = null;
        ListNode tempResultNode = resultHead;
        ListNode prev = null;
        ListNode temp = head;

        while(temp!=null){
            ListNode newNode = new ListNode(temp.data);
            //case 1
            if(resultHead==null){
                resultHead = newNode;
                tempResultNode = resultHead;
            }
            else{
                //checking the data
                while(tempResultNode!=null && tempResultNode.data<temp.data){
                        prev=tempResultNode;
                        tempResultNode= tempResultNode.next;
                }

                //inserting data;
                if(prev==null){
                    newNode.next = resultHead;
                    resultHead = newNode;
                }else{
                    newNode.next = prev.next;
                    prev.next = newNode;
                }
            }
            //resetting the nodes
            prev = null;
            tempResultNode = resultHead;
            temp=temp.next;

        }

        return resultHead;

    }

        // Function to sort the linked list of 0's, 1's and 2's
    public static void sortLinkedList(ListNode head) {
            int[] count = {0, 0, 0};
            ListNode current = head;

            // Count the number of 0's, 1's and 2's
            while (current != null) {
                count[current.data]++;
                current = current.next;
            }

            int i = 0;
            current = head;

            // Update the linked list with sorted data
            while (current != null) {
                if (count[i] == 0) {
                    i++;
                } else {
                    current.data = i;
                    count[i]--;
                    current = current.next;
                }
            }
        }

        public static ListNode sortLinkedListV2(ListNode head){

        //Create three dummy nodes
            ListNode zeroHead = new ListNode(-1);
            ListNode zeroTail = zeroHead;
            ListNode oneHead = new ListNode(-1);
            ListNode oneTail = oneHead;
            ListNode twoHead = new ListNode(-1);
            ListNode twoTail = twoHead;

            ListNode temp = head;
            while(temp!=null){
                ListNode nextNode = temp.next;
                if(temp.data==0){
                    temp.next = null;
                    zeroTail.next = temp;
                    zeroTail = zeroTail.next;
                }else if(temp.data==1){
                    temp.next = null;
                    oneTail.next = temp;
                    oneTail = oneTail.next;
                }else {
                    temp.next = null;
                   twoTail.next= temp;
                   twoTail= twoTail.next;
                }
                temp = nextNode;
            }
            if(oneHead.next==null){
                zeroTail.next=twoHead.next;
            }else{
                zeroTail.next=oneHead.next;
                oneTail.next = twoHead.next;
            }
            //deleting dummies
            oneHead.next=null;
            twoHead.next=null;
            ListNode tempZero = zeroHead;
            zeroHead = zeroHead.next;
            tempZero.next=null;
            return zeroHead;
        }
}
