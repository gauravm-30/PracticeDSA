package org.practice.arrays.commonbasicquestions;

import java.util.*;

public class RemoveDuplicateNumbers {
    public static void main(String[] args){

    }

    //Using Set
    public static List<Integer> removeDuplicateElementsUsingSet(int[] nums){
      Set<Integer> integerSet = new HashSet<>();
      for(int i = 0; i < nums.length; i++) {
          integerSet.add(nums[i]);
      }

      return new ArrayList<>(integerSet);
    }

    //Using List
    public static List<Integer> removeDuplicateElementsUsingList(int[] nums){
    List<Integer> integerList = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
          if(!integerList.contains(nums[i])){
              integerList.add(nums[i]);
          }
        }
        return integerList;
    }

    //Using Two pointer technique
    //if array is sorted
    //returning the length of array after removing duplicates
    public static int removeDuplicateElementsUsingTwoPointer(int[] nums){
        if(nums.length<2){
            return nums.length;
        }
        int i = 0;
        int j = i+1;

        while(j<nums.length){
           if(nums[i]==nums[j]){
               j++;
               continue;
           }
           else {
               i++;
               nums[i]= nums[j];
               j++;
           }
        }
        return i+1; //returning the length of the unique element array
    }
}
