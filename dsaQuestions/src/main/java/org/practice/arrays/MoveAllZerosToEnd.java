package org.practice.arrays;

// https://leetcode.com/problems/move-zeroes/description/
public class MoveAllZerosToEnd {

  // Use two pointer technique
  public static void moveZeroes(int[] nums) {
    int z = 0; // will represent the index of zero value
    int nz = 0; // will represent the index of non-zero value
    while (nz < nums.length) {
      // move till nz is at non-zero element
      if (nums[nz] == 0) {
        nz++;
      } else {
        swap(z, nz, nums);
        z++;
        nz++;
      }
    }
  }

  private static void swap(int z, int nz, int[] nums) {
    int temp = nums[z];
    nums[z] = nums[nz];
    nums[nz] = temp;
  }
}
