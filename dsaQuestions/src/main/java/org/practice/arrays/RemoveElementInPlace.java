package org.practice.arrays;

// https://leetcode.com/problems/remove-element/description/
public class RemoveElementInPlace {

  public static void runRemoveElement() {
    int[] arr = {};
    System.out.println(removeElement(arr, 1));
  }

  // use two pointer technique
  public static int removeElement(int[] nums, int val) {
    int i = 0;
    int j = nums.length - 1;
    while (i <= j) {
      if (nums[i] != val) {
        i++;
      } else {
        swap(nums, i, j);
        j--;
      }
    }
    return j + 1;
  }

  private static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
