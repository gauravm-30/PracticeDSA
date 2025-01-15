package org.practice.arrays.slidingwindow.variablesize;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {
    public static void main(String[] args){
        int[] arr = {4,1,1,1,2,3,5};
        int[] arr2 = {1,10,2,3,5};
    System.out.println(getLongestSubArraysOfSumKV3(arr2, 5));
    }

  // Brute Force Approach
  // https://www.geeksforgeeks.org/longest-sub-array-sum-k/
  //    [Naive Approach] Using Nested Loop – O(n^2) Time and O(1) Space
  // The idea is to check the sum of all the subarrays
    // and return the length of the longest subarray
  // having the sum k.
   public  static int longestSubarray(int[] arr, int k) {
        int res = 0;

        for (int i = 0; i < arr.length; i++) {

            // Sum of subarray from i to j
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                // If subarray sum is equal to k
                if (sum == k) {

                    // find subarray length and update result
                    int subLen = j - i + 1;
                    res = Math.max(res, subLen);
                }
            }
        }

        return res;
    }


// https://youtu.be/yDeNqw_dAU0
 private static int longestSubarrayV2(int[] arr, int k) {
    Map<Integer, Integer> mp = new HashMap<>();
    int res = 0;
    int prefSum = 0;

    for (int i = 0; i < arr.length; ++i) {
        prefSum += arr[i];

        // Check if the entire prefix sums to k
        if (prefSum == k)
            res = i + 1;

            // If prefixSum - k exists in the map then there exist such
            // subarray from (index of previous prefix + 1) to i.
        else if (mp.containsKey(prefSum - k))
            res = Math.max(res, i - mp.get(prefSum - k));

        // Store only first occurrence index of prefSum
        if (!mp.containsKey(prefSum))
            mp.put(prefSum, i);
    }

    return res;
}



    // O(n*n)
  // variable size sliding window
  private static int getLongestSubarrayLengthOfSumK(int[] nums, int sum) {
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

    //O(n*n)
    private static void getLongestSubArraysOfSumKV2(int[] nums , int sum){
        int i = 0;
        int j = 0;
        int currentSum = 0;
        int maxLength = 0;

        while (j<nums.length){
            currentSum+=nums[j];
            if(currentSum<sum){
                j++;
            }else {
                if(currentSum==sum){
                    if(maxLength<(j-i+1))
                    {
                        maxLength= j-i+1;
                    }
                }
                //resetting the window and current sum
                i++;
                j=i;
                currentSum=0;
            }
        }

    }
//positive numbers only
    private static int getLongestSubArraysOfSumKV3(int[] nums , int sum){
        int i = 0;
        int j = 0;
        int currentSum = 0;
        int maxLength = 0;

        while (j<nums.length){
            currentSum+=nums[j];
                if(currentSum<sum){
                 j++;
            }else if(currentSum==sum){
                    if(maxLength<(j-i+1))
                    {
                        maxLength= j-i+1;
                    }
                    j++;
            }else {
                while(currentSum>sum){
                    currentSum-=nums[i];
                    i++;
                }
                j++;
            }
        }
        return maxLength;
    }

//Optimized O(n)
//sliding window algo
    private static int getLongestSubArraysOfSumKV4(int[] nums , int sum){
        int i = 0;
        int j = 0;
        int currentSum = 0;
        int maxLength = 0;

        while (j<nums.length){
            currentSum+=nums[j];
            if(currentSum==sum){
                if(maxLength<(j-i+1))
                {
                    maxLength= j-i+1;
                }
            }else {
                while(currentSum>sum){
                    currentSum-=nums[i];
                    i++;
                }
            }
            j++;
        }
        return maxLength;
    }
}
