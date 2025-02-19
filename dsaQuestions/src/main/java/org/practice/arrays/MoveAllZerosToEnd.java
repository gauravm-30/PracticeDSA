package org.practice.arrays;

// https://leetcode.com/problems/move-zeroes/description/
public class MoveAllZerosToEnd {

  // Use two pointer technique
  public static void moveZeroes(int[] nums) {
    int zIndex = 0; // will represent the index of zero value , currentIndex
    int nzIndex = 0; // will represent the index of non-zero value
    while (nzIndex < nums.length) {
      // move till nzIndex is at non-zero element
      if (nums[nzIndex] == 0) {
        nzIndex++;
      } else {
        swap(zIndex, nzIndex, nums);
        zIndex++;
        nzIndex++;
      }
    }
  }

  private static void swap(int z, int nz, int[] nums) {
    int temp = nums[z];
    nums[z] = nums[nz];
    nums[nz] = temp;
  }
}
