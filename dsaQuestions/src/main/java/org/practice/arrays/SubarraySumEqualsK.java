package org.practice.arrays;

import java.util.List;

//https://leetcode.com/problems/subarray-sum-equals-k/description/
public class SubarraySumEqualsK {
    public static void main(String[] args){
      int[] nums = {4,1,1,1,2,3,5};
      int sum = 5;
    System.out.println(getAllSubArraysOfSumKV3(nums, sum));
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
