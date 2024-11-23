package org.practice.arrays.intersection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

//Unsorted + Distinct Elements are allowed
public class IntersectionOfTwoUnSortedArraysII {
  public static void main(String[] args) {}

//Brute force approach
//TC O(n*m)
//SC O(1)
  public static int[] intersection(int[] nums1, int[] nums2) {
    //Or Use the ArrayList<Integer>
      int resultLength = Math.min(nums1.length,nums2.length);
      int[] result = new int[resultLength];
    Arrays.fill(result,Integer.MIN_VALUE);
      int k = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    result[k++]=nums1[i];
                    break;
                }
            }
        }
        return result;
    }

    //Approach 3
    //Sort the array and then use two pointer technique i.e. as in intersection of two sorted arrays with distinct elements
    //TC O(N*logN)
    //If we consider only unique element is present in both the arrays then
    // isElementPresent is not required and we will get the result in
    //TC O(m)
    public int[] intersectionOfSortedArraysUsingTwoPointer(int[] nums1,int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int resultLength = Math.max(nums1.length,nums2.length);
        int[] result = new int[resultLength];
        int k = 0;
        int i = 0;
        int j = 0;

        while(i<nums1.length && j<nums2.length){
            //common element found
            if(nums1[i]==nums2[j]){
                result[k++]=nums1[i];
                i++;
                j++;
            }else if(nums1[i]<nums2[j]){
                i++;
            }else {
                j++;
            }
        }
        return result;
    }


//    Using Hash Set - O(n+m) Time and O(n) Space
static ArrayList<Integer> intersect(int[] a, int[] b) {

    // Put all elements of a[] in hash set
    HashSet<Integer> st = new HashSet<>();
    for (int num : a) {
        st.add(num);
    }
    ArrayList<Integer> res = new ArrayList<>();
    for (int i = 0; i < b.length; i++) {

        // If the element is in st
        // then add it to result array
        if (st.contains(b[i])) {
            res.add(b[i]);
        }
    }

    return res;
}


}
