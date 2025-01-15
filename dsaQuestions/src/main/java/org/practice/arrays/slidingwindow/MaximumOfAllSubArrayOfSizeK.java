package org.practice.arrays.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/sliding-window-maximum/description/
public class MaximumOfAllSubArrayOfSizeK {
    public static void main(String[] args){
     int[] res=maxSlidingWindowV2(new int[]{1,3,-1,-3,5,3,6,7},3);
    }

    //Brute Force Approach
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length<k){
            throw new RuntimeException("Invalid");
        }
        int[] arr = new int[nums.length-k+1];
        for(int i = 0; i<arr.length;i++){
            int max = maxFromSubArray(nums,i,i+k-1);
            arr[i]=max;
        }
        return arr;
    }

    private int maxFromSubArray(int[] nums,int start,int end){
        int max = nums[start];
        for(int i = start+1;i<=end;i++){
            if(max<nums[i]){
                max=nums[i];
            }
        }
        return max;
    }


    //Sliding Window Protocol
    //O(n)
    //for understanding purpose
    public static int[] maxSlidingWindowV2(int[] nums,int k){
        int i = 0 ;
        int j = 0 ;
        int m = 0 ;
        int[] res = new int[nums.length-k+1];
        Deque<Integer> integerDeque = new ArrayDeque<>();
        while (j<nums.length){
            if(j-i+1<k){
                if(integerDeque.isEmpty()){
                    integerDeque.offerLast(nums[j]);
                }else {
                    while (!integerDeque.isEmpty() && nums[j]>integerDeque.peekLast()){
                        integerDeque.pollLast();
                    }
                    integerDeque.offerLast(nums[j]);
                }
                j++;
            }else if(j-i+1==k){
                if(integerDeque.isEmpty()){
                    integerDeque.offer(nums[j]);
                }else {
                    while (!integerDeque.isEmpty() && nums[j]>integerDeque.peekLast()){
                        integerDeque.pollLast();
                    }
                    integerDeque.offer(nums[j]);
                }
                if(!integerDeque.isEmpty()){
                    res[m++]=integerDeque.peekFirst();
                    if(nums[i]==integerDeque.peekFirst()){
                        integerDeque.pollFirst();
                    }
                }
                i++;
                j++;
      }
        }

        return res;
    }

    //Optimized solution for sliding window
    //O(n)
    public static int[] maxSlidingWindowV3(int[] nums,int k){
        int i = 0 ;
        int j = 0 ;
        int[] res = new int[nums.length-k+1];
        Deque<Integer> integerDeque = new ArrayDeque<>();
        while (j<nums.length){
            if(integerDeque.isEmpty()){
                integerDeque.offerLast(nums[j]);
            }else {
                while (!integerDeque.isEmpty() && nums[j]>integerDeque.peekLast()){
                    integerDeque.pollLast();
                }
                integerDeque.offerLast(nums[j]);
            }
            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
                if(!integerDeque.isEmpty()){
                    res[i]=integerDeque.peekFirst();
                    if(nums[i]==integerDeque.peekFirst()){
                        integerDeque.pollFirst();
                    }
                }
                i++;
                j++;
            }
        }

        return res;
    }

}
