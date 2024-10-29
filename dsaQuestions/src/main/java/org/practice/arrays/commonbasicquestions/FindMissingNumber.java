package org.practice.arrays.commonbasicquestions;

import java.util.Arrays;

public class FindMissingNumber {
    //    https://leetcode.com/problems/missing-number/description/
    public static void main(String[] args){

    }

    //Constraints :
    // all the numbers are unique
    // only one number is missing
    // numbers are from [0,N] or either [1,N]  depend on question


    //Brute force approach
    //Since it is using merge sort, so
    // TC - O(nlogn)
    public static int missingNumber(int[] arr){
     //initial checks
     if(arr==null || arr.length==0){
         throw new RuntimeException("Provide valid arr");
     }
    Arrays.sort(arr);
    for(int i = 0; i < arr.length; i++) {
      if((arr[i]-i)!=0){
        return i;
      }
    }
    return arr.length;
    }

    //Efficient approach
    //Use cyclic sort
    //It is used when the numbers are in some range  like  [0,N] or [1,N]
    //TC O(N)
    private static int findMissingNumber(int[] arr) {
        applyCyclicSort(arr);
        // search for the first missing number
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i) {
                return i;
            }
        }
        // If not returned in for loop means largest element is not present i.e.
        return arr.length;
    }

    // Important Note :
    // [4,0,1,2] whenever such case arise apply cyclic  sort , and whenever you see element whose
    // index will be out of bound just ignore it.
    private static void applyCyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i];
            // If arr[i] >= arr.length then ignore it ,i.e. out of bound exception
            if (arr[i] < arr.length && arr[i] != arr[correctIndex]) {
                swap(arr, i, correctIndex);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] arr, int i ,int correctIndex) {
        int temp = arr[correctIndex];
         arr[correctIndex] = arr[i] ;
         arr[i]= temp;


    }
}
