package org.practice.arrays.commonbasicquestions;

//https://leetcode.com/problems/find-the-duplicate-number/
public class FindDuplicateNumber {
    public static void main(String[] args){

    }
    //Brute force approach
    //Create an array of  n size and fill it up based on the nums
    public int getDuplicateNumberBruteForce(int[] nums){
        return 0;
    }

    //Constraints :
    // all the numbers are unique except one which is repeated
    // numbers are from [0,N] or either [1,N]  depend on question
    public int getDuplicateNumber(int[] nums){
        applyCyclicSortForDuplicate(nums);
        for(int i = 0; i < nums.length; i++) {
            if(nums[i]!=i+1){
                return nums[i];
            }
        }
        return -1;
    }

    private void applyCyclicSortForDuplicate(int[] nums) {
        int i = 0;
        while (i<nums.length){
            int correctIndex = nums[i]-1; //correct index for nums[i]
            if(nums[i]!=nums[correctIndex]){
                swap(i,correctIndex,nums);
            }else {
                i++;
            }

        }
    }

    private void swap(int i, int correctIndex, int[] nums) {
        int temp = nums[correctIndex];
        nums[correctIndex] = nums[i];
        nums[i]=temp;
    }
}
