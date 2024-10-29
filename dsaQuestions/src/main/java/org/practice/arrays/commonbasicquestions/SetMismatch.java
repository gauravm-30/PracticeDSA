package org.practice.arrays.commonbasicquestions;


public class SetMismatch {
    public static void main(String[] args){

    }

//  https://leetcode.com/problems/set-mismatch/
    public static int[] findErrorNums(int[] nums){
        applyCyclicSort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(nums[i]!=i+1){
                return new int[]{nums[i],i+1};
            }
        }

        return new int[]{Integer.MIN_VALUE,Integer.MIN_VALUE};
    }

    private static void applyCyclicSort(int[] nums) {
        int i = 0 ;
        while(i<nums.length){
            int correctIndex = nums[i]-1;
            if(nums[i]!=nums[correctIndex]){
                swap(i,correctIndex,nums);
            }else {
                i++;
            }
        }
    }

    private static void swap(int i, int correctIndex, int[] nums) {
        int temp = nums[correctIndex];
        nums[correctIndex]= nums[i];
        nums[i]=temp;
    }
}
