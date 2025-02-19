package org.practice.arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/subarray-sum-equals-k/description/
public class SubarraySumEqualsK {
    public static void main(String[] args){
      int[] nums = {4,1,1,1,2,3,5};
      int sum = 5;
    System.out.println(getAllSubArraysOfSumKV3(nums, sum));
    }


    //brute force approach
    //find all subarrays and their sum.
    //If their sum is equal to the target or not.
    private static void getAllSubarraysOfSumK(int[] nums, int target){
        int count = 0;
    for (int start = 0; start < nums.length; start++) {
      for (int end = 0; end < nums.length; end++) {
          int sum=0;
          for(int i = start; i <=end; i++) {
              sum+=nums[i];
          }
          if(sum==target){
              count++;
          }
      }
    }
    }


//    https://youtu.be/20v8zSo2v18 pepcoding
    //Hashmap and prefixSum approach
    private static int getAllSubarraysOfSumKV4(int[] nums, int target){
        int count = 0;
        Map<Integer,Integer> prefixSumFreq = new HashMap<>();
        //We put firstly (0,1)
        //consider following edge cases -
        // [3,2,6] and k = 5
        // [1,-1,0]  and k = 0
        //[0,0,0,0]  and k = 0
        prefixSumFreq.put(0,1);

        int cumulativeSum = 0;
    for (int i = 0; i < nums.length; i++) {
         cumulativeSum+=nums[i];
         if(prefixSumFreq.containsKey(cumulativeSum-target)){
             count=count+ prefixSumFreq.get(cumulativeSum-target);
         }
         prefixSumFreq.put(cumulativeSum,prefixSumFreq.getOrDefault(cumulativeSum,0)+1);
    }
       return count;
    }



    //O(n)
    private static void getAllSubArraysOfSumK(int[] nums , int sum){
        int i = 0;
        int j = 0;
        int currentSum = 0;

            while (j<nums.length){
                currentSum+=nums[j];

                if(currentSum==sum){
          // print the length of subarray O(1)
                    System.out.println("Subarray length is " + (j-i+1));
                    //print the subarray
                    i++;
                    j=i;
                    currentSum=0;
                }
                else if(currentSum>sum){
                       i++;
                       j=i;
                       currentSum=0;
                    }
                else {
                    j++;
                }

            }

    }
//More optimized code
    //O(n)
    private static void getAllSubArraysOfSumKV2(int[] nums , int sum){
        int i = 0;
        int j = 0;
        int currentSum = 0;

        while (j<nums.length){
            currentSum+=nums[j];
            if(currentSum<sum){
                j++;
            }else {
                if(currentSum==sum){
                    System.out.println("Subarray length is " + (j-i+1));
                }
                i++;
                j=i;
                currentSum=0;
            }
        }

    }


    //O(n)
    private static int getAllSubArraysOfSumKV3(int[] nums , int sum){
        int i = 0;
        int j = 0;
        int currentSum = 0;
        int maxLength = 0;

        while (j<nums.length){
            currentSum+=nums[j];

            if(currentSum==sum){
                // print the length of subarray O(1)
                if(maxLength<(j-i+1))
                {
                    maxLength= j-i+1;
                }
                //print the subarray
                i++;
                j=i;
                currentSum=0;
            }
            else if(currentSum>sum){
                i++;
                j=i;
                currentSum=0;
            }
            else {
                j++;
            }

        }
        return maxLength;
    }


}
