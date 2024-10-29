package org.practice.arrays.commonbasicquestions;

public class LargestAndSmallestNumber {
    public static void main(String[] args){

    }

    public void getLargestSmallestNumberInUnsortedArray(int[] arr){
        if(arr==null || arr.length==0){
            throw  new RuntimeException("Array is not valid");
        }

        int maxElement = arr[0];
        int minElement = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if(maxElement< arr[i]){
            maxElement=arr[i];
        }else {
            if(minElement>arr[i]){
                minElement=arr[i];
            }
        }
    }
    System.out.println(maxElement);
    System.out.println(minElement);
    }
}
