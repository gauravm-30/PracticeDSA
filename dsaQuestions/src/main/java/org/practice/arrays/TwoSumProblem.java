package org.practice.arrays;

import java.util.Arrays;
import java.util.HashMap;

// https://leetcode.com/problems/two-sum/description/
public class TwoSumProblem {

  // brute force approach

  public static int[] twoSumV1(int[] arr, int target) {

    // minimum two elements required in the array.
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] + arr[j] == target) {
          return new int[] {i, j};
        }
      }
    }
    return new int[] {-1, -1};
  }

  // sort the array and use two pointers technique
  // Warning Changes the index value so not applicable, works best for true/false
  public static int[] twoSumV2(int[] arr, int target) {
    Arrays.sort(arr);
    int left = 0;
    int right = arr.length - 1;

    while (left < right) {
      if (arr[left] + arr[right] == target) {
        return new int[] {left, right};
      } else if (arr[left] + arr[right] > target) {
        right--;
      } else {
        left++;
      }
    }
    return new int[] {-1, -1};
  }

  // sort the array and use binary Search technique
  // Sort the array, then traverse the array elements and perform binary search for (target – a[i])
  // on the remaining part
  // Warning but changes the index values. So not applicable
  public static int[] twoSumV3(int[] arr, int target) {
    Arrays.sort(arr);
    int left = 0;
    int right = arr.length - 1;
    for (int i = 0; i < arr.length; i++) {
      int remainingVal = target - arr[i];
      // now search this remaining value in sorted arr and return thn index;
      int remainingValIndex = Arrays.binarySearch(arr, i + 1, arr.length, target);
      if (remainingValIndex >= 0) {
        return new int[] {i, remainingValIndex};
      }
    }
    return new int[] {-1, -1};
  }

  // use the hashmap to check for value target - a[i]
  // You can return the answer in any order.
  // O(N) TC
  // O(N) SC

  public static int[] twoSumV4(int[] arr, int target) {
    // create a map which maintains the value and its index also
    HashMap<Integer, Integer> indexMap = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      int remainingValue = target - arr[i];
      if (indexMap.containsKey(remainingValue)) {
        return new int[] {i, indexMap.get(remainingValue)};
      } else {
        indexMap.put(arr[i], i);
      }
    }
    return new int[] {-1, -1};
  }
}
