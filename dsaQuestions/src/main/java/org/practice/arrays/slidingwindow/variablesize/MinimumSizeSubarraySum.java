package org.practice.arrays.slidingwindow.variablesize;
//https://leetcode.com/problems/minimum-size-subarray-sum/submissions/1508355323/
public class MinimumSizeSubarraySum {
    public static void main(String[] args){

    }

    //Sliding Window
//    O(N+N)
    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0 ;
        int j = 0 ;
        int currSum = 0;
        int minLength = Integer.MAX_VALUE;
        while(j<nums.length){
            currSum+=nums[j];
            while(currSum>=target){
                if(minLength>j-i+1){
                    minLength =j-i+1;
                }
                currSum-=nums[i];
                i++;
            }
            j++;
        }
        return minLength==Integer.MAX_VALUE?0:minLength;
    }

    //Sliding Window understand
    public static int minSubArrayLenV2(int target, int[] nums) {
        int i = 0 ;
        int j = 0 ;
        int currSum = 0;
        int minLength = Integer.MAX_VALUE;
        while(j<nums.length){
            currSum+=nums[j];
            if(currSum<target){
                j++;
            }else {
                while(currSum>=target){
                    if(minLength>j-i+1){
                        minLength =j-i+1;
                    }
                    currSum-=nums[i];
                    i++;
                }
                j++;
            }

        }
        return minLength==Integer.MAX_VALUE?0:minLength;
    }
}
