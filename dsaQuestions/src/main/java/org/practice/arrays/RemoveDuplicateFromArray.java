package org.practice.arrays;

// Remove duplicates from sorted Array
// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
public class RemoveDuplicateFromArray {

  public static void runRemoveDuplicates() {
    int[] sortedArr = {1, 2, 3, 4, 4, 5, 5, 5, 5, 5, 6, 7, 7};
    int length = removeDuplicateElementsFromSortedArrV1(sortedArr);
    for (int i = 0; i < length; i++) {
      System.out.printf(" " + sortedArr[i]);
    }
  }

  // two pointer technique
  public static int removeDuplicateElementsFromSortedArrV1(int[] arr) {
    int i = 0;
    for (int j = 1; j < arr.length; j++) {
      if (arr[i] != arr[j]) {
        i++;
        arr[i] = arr[j];
      }
    }
    return i + 1;
  }

  //  two pointer technique
  public static int removeDuplicateElementsFromSortedArrV2(int[] arr) {
    int i = 0;
    int j = 1;
    while (j < arr.length) {
      if (arr[i] != arr[j]) {
        i++;
        arr[i] = arr[j];
      }
      j++; // j will be incremented in both cases
    }
    return i + 1;
  }

  public static int removeDuplicateElementsFromSortedArrV3(int[] arr) {
    int i = 0;
    int j = 1;
    while (j < arr.length) {
      if (arr[i] != arr[j]) {
        i++;
        arr[i] = arr[j];
        j++;
      } else {
        j++; // j will be incremented in both cases
      }
    }
    return i + 1;
  }
}
