package org.practice.arrays;

// https://leetcode.com/problems/maximum-subarray/description/
// Given an integer array nums, find the
// subarray
// with the largest sum, and return its sum.
public class MaximumSumSubarray {

  // approach says that maintain two variable i.e. current sum and maximumSum
  public static int maximumSumSubarray(int[] nums) {
    int maximumSum = Integer.MIN_VALUE;
    int currentSum = 0;
    for (int i = 0; i < nums.length; i++) {
      currentSum = currentSum + nums[i];
      if (currentSum > maximumSum) {
        maximumSum = currentSum;
      }
      if (currentSum < 0) {
        currentSum = 0;
      }
    }

    return maximumSum;
  }
}
