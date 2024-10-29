package org.practice.arrays.commonbasicquestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicateNumberII {
    public static void main(String[] args){
    int[] nums  = {1,1};
    int[] nums1  = {1,2};
    int[] nums2  = {1,2,3};
    int[] nums3  = {1,1,2,3,3,3,3,3,3};
    int[] nums4  = {100,100,2,322,322,322,325,23,23};
    System.out.println(duplicateNumbersTwoPointers(nums4));
    }

    //TC O(N)
    //SC O(N)
    public static List<Integer> duplicateNumbers(int[] nums){
        List<Integer> duplicateList = new ArrayList<>();
        if(nums.length<1){
            return duplicateList;
        }
        Set<Integer> integerSet = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
       if(!integerSet.add(nums[i])){
           duplicateList.add(nums[i]);
       }
    }
           return duplicateList;
    }


    //Using two pointer technique
    //TC O(N)
    //SC O(1)
    //Warning Element in array is already sorted
    public static List<Integer> duplicateNumbersTwoPointers(int[] nums){
        List<Integer> duplicateList = new ArrayList<>();
        if(nums.length<1){
            return duplicateList;
        }
        int i = 0;
        int j = i+1;
        while(j<nums.length){
            int duplicateElement = Integer.MIN_VALUE;
            while(j < nums.length && nums[i]==nums[j]){
                duplicateElement = nums[i];
                j++;
            }
            if(duplicateElement!=Integer.MIN_VALUE){
                duplicateList.add(duplicateElement);
            }
            i=j;
            j=i+1;
        }
        return duplicateList;
    }
}
