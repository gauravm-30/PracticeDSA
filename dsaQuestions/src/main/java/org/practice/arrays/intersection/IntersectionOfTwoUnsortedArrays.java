package org.practice.arrays.intersection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Any number of elements + Unsorted  + Duplicate elements are allowed
public class IntersectionOfTwoUnsortedArrays {
    public static void main(String[] args){

    }

    //Brute force approach
    //TC (N*M*K)
    public int[] intersectionOfTwoSortedArraysBruteForce(int[] nums1,int[] nums2){
        int resultLength = Math.min(nums1.length,nums2.length);
        int[] result = new int[resultLength];
        Arrays.fill(result,Integer.MIN_VALUE);
        int k = 0;
        for(int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if(nums1[i]==nums2[j] && !isElementPresent(result,nums1[i])){
                    result[k++]=nums1[i];
                }
            }
        }
        return result;
    }


    private boolean isElementPresent(int[] result, int element) {
        for(int j = 0; j < result.length; j++) {
            if(element==result[j]){
                return true;
            }
        }
        return false;
    }

    //Using Set
    //TC O(n+m)
    //SC O(Max(N,M))
    public int[] intersectionOfSortedArraysUsingSet(int[] nums1,int[] nums2){
        Set<Integer> integerSet = new HashSet<>();
        int resultLength = Math.max(nums1.length,nums2.length);
        int[] result = new int[resultLength];
        int k =0;
        for(int i = 0; i < nums1.length; i++) {
            integerSet.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++) {
            if(!integerSet.add(nums2[i])){
                result[k++]=nums2[i];
            }
        }
        return result;
    }
}
