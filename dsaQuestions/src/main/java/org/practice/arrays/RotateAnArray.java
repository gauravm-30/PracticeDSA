package org.practice.arrays;

// https://leetcode.com/problems/rotate-array/description/
public class RotateAnArray {
  // Rotate an array k times

  // approach 1
  // shift the array to the right by k times
  // TC (N*K)

  // approach 2
  // take the array copy and use it to recopy into the original array
  // SC(N) TC (N)

  // approach 3
  // reverse the array 3 times
  private static void rotateArray(int[] nums, int k) {

    int n = nums.length;
    // Handle edge cases
    if (n <= 1 || k % n == 0) {
      return;
    }
    k = k % n;
    reverseArray(nums, 0, k - 1);
    reverseArray(nums, n - k, n - 1);
    reverseArray(nums, 0, n - 1);
  }

  private static void reverseArray(int[] nums, int sIndex, int eIndex) {
    while (sIndex < eIndex) {
      swap(nums, sIndex, eIndex);
      sIndex++;
      eIndex--;
    }
  }

  private static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
