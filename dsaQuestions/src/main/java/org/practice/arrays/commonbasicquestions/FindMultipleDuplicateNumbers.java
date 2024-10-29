package org.practice.arrays.commonbasicquestions;


import java.util.ArrayList;
import java.util.List;

public class FindMultipleDuplicateNumbers {
    public static void main(String[] args){

    }
    //  https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
    public static List<Integer> findAllDuplicateElement(int[] nums) {
        // Question is saying that each element appears once or twice ,so no need to use hashset
        //    Set<Integer> missing = new HashSet<>();
        List<Integer> duplicateNums = new ArrayList<>();
        applyCyclicSortForDuplicateElement(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                duplicateNums.add(nums[i]);
            }
        }

        //    for (int ele : missing) {
        //      arr.add(ele);
        //    }
        return duplicateNums;
    }

    // for [1,n]
    private static void applyCyclicSortForDuplicateElement(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1; // correct index of the element 'nums[i]'
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
