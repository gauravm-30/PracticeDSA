package org.practice.arrays;

public class MajorityElement {
  public static void main(String[] args) {
    int[] arr = {2, 9, 1, 2, 3, 2, 2, 3, 2};
  }

  // Majority Element
  //  https://leetcode.com/problems/majority-element/description/

  // Approach 1
  // Use the hashmap to count the frequencies .

  // Approach 2
  // Boyer Moore Voting Algorithm
  private static int majorityElement(int[] arr) {

    if (arr.length == 0 || arr.length == 1) {
      return Integer.MIN_VALUE;
    }
    int count = 1;
    int majorityElement = arr[0];
    for (int i = 0; i < arr.length; i++) {
      if (majorityElement == arr[i]) {
        count++;
      } else if (count == 0) {
        majorityElement = arr[i];
        count = 1;
      } else {
        count--;
      }
    }

    // verify  whether it is really a majority element
    int realCount = 0;
    for (int ele : arr) {
      if (ele == majorityElement) {
        realCount++;
      }
    }

    if (realCount > (arr.length / 2)) {
      return majorityElement;
    }
    return Integer.MIN_VALUE;
  }

  // Majority Element II
  // Approach 1
  // Use the hashmap and count the frequencies

  // Approach 2
  private static int[] majorityElements(int[] nums) {
    int[] majorityElements = {Integer.MIN_VALUE, Integer.MIN_VALUE};

    int majorityElement1 = Integer.MIN_VALUE, majorityElement2 = Integer.MIN_VALUE;
    int count1 = 0, count2 = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == majorityElement1) {
        count1++;
      } else if (nums[i] == majorityElement2) {
        count2++;
      } else if (count1 == 0) {
        majorityElement1 = nums[i];
        count1 = 1;
      } else if (count2 == 0) {
        majorityElement2 = nums[i];
        count2 = 1;
      } else {
        count1--;
        count2--;
      }
    }

    // verification
    int freq1 = 0;
    int freq2 = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == majorityElement1) {
        freq1++;
      } else if (nums[i] == majorityElement2) {
        freq2++;
      }
    }
    if (freq1 > (nums.length) / 3) {
      majorityElements[0] = majorityElement1;
    }
    if (freq2 > (nums.length) / 3) {
      majorityElements[1] = majorityElement2;
    }

    return majorityElements;
  }
}
