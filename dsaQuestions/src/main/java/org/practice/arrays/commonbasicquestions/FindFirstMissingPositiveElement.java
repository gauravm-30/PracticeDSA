package org.practice.arrays.commonbasicquestions;

public class FindFirstMissingPositiveElement {
    public static void main(String[] args){

    }

    public static int firstMissingNumberBruteForce(int[] nums){
        //First take out only positive integer from the array and store in to another array.
        // sort them
        // then apply
        // case 1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // case 2
        return nums.length + 1;
    }

    //  https://leetcode.com/problems/first-missing-positive/description/
    public static int firstMissingPositive(int[] nums) {
        applyCyclicSortForFirstMissingPositive(nums);
        // case 1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // case 2
        return nums.length + 1;
    }

    private static void applyCyclicSortForFirstMissingPositive(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1; // correct index of the element 'nums[i]'
            // nums[i] > 0 &&  nums[i] < nums.length  this is to ignore cyclic sorting for elements<=0 or
            // greater than length
            if (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[correctIndex]) {
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
