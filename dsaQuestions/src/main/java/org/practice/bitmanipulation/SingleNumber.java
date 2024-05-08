package org.practice.bitmanipulation;

// https://leetcode.com/problems/single-number/description/
public class SingleNumber {

  public static void runSingleNumber() {
    int[] nums = {2, 2, 3, 3, 1};
    System.out.println(getSingleNumber(nums));
  }

  // Approach 1
  // Brute Force Approach
  // Take O(N2)
  public static int getSingleNumber(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      boolean isDuplicatePresent = false;
      for (int j = 0; j < nums.length; j++) {
        if (i != j && nums[i] == nums[j]) {
          isDuplicatePresent = true;
          break;
        }
      }
      if (!isDuplicatePresent) {
        return nums[i];
      }
    }
    return -1;
  }

  // Approach 2
  // Sorting approach takes O(NlogN)
  // then compare the current and it next element.

  // Approach 3
  // Using hashmap to store the freq of elements
  // SC O(N) and TC O(N)

  // Approach 4
  // Using Bit Manipulations
  // Using Xor operations
  public static int singleNumber(int[] nums) {
    int result = 0;
    for (int loop = 0; loop < nums.length; loop++) {
      result = result ^ nums[loop];
    }
    return result;
  }
}
