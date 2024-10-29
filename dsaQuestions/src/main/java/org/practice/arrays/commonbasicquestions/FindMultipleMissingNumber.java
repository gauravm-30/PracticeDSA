package org.practice.arrays.commonbasicquestions;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
public class FindMultipleMissingNumber {
    public static void main(String[] args){
     int[] nums = {4,3,2,7,8,2,3,1};
    System.out.println(findDisappearedNumbers(nums));
     }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        applyCyclicSortForDisappearedNumbers(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                missingNumbers.add(i + 1);
            }
        }
        return missingNumbers;
    }
   //From below algo numbers will be placed at their correct index
    //For ex  - [4,3,2,7,8,2,3,1]
    // o/p after sorting - [1,2,3,4,3,2,7,8]
    //If we closely observe then we can say that all the number are in their correct place.
    private static void applyCyclicSortForDisappearedNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            // it is giving the correct index of value present at ith index
            // we should ignore if current index and correct index values are same.If we swap then it will
            // go into infinite loop
            // For ex: [5,2,3,4,5,5,5]  Here infinite may occur as 5 is at its correct position and its on
            // zero index also
            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
