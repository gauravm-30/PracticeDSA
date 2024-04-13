package org.practice.searching.BinarySearch;

public class BinarySearchLeetCodePart3 {

  public static void runBinarySearchLeetCodePart3() {
    int[] rotatedSortedArr1 = {1, 1, 1, 9, 1};
    int[] rotatedSortedArr2 = {9, 1, 9, 9, 9};
    int[] rotatedSortedArr3 = {9, 10, 1, 9, 9, 9, 9};
    System.out.println("Arr1" + findPivotWithDuplicatesIn(rotatedSortedArr1));
    System.out.println("Arr2" + findPivotWithDuplicatesIn(rotatedSortedArr2));
    System.out.println("Arr3" + findPivotWithDuplicatesIn(rotatedSortedArr3));
  }

  // Problem 1: https://leetcode.com/problems/search-in-rotated-sorted-array/description/
  // Search the target element index in rotated sorted array without the duplicate keys
  // this will not work in case of duplicate values
  public static int searchInRotatedArray(int[] arr, int target) {
    int pivotIndex = findPivotIndexWithoutDuplicatesIn(arr);
    // if pivot is not found then it means array is not rotated.
    if (pivotIndex == -1) {
      // just do a normal binary search
      return binarySearchOrderAgnostic(arr, target, 0, arr.length - 1);
    }
    if (arr[pivotIndex] == target) {
      return pivotIndex;
    }
    if (target >= arr[0]) {
      // means search in first half
      return binarySearchOrderAgnostic(arr, target, 0, pivotIndex - 1);
    }

    return binarySearchOrderAgnostic(arr, target, pivotIndex + 1, arr.length - 1);
  }

  // we know that the array is sorted and rotated and with distinct numbers
  public static int findPivotIndexWithoutDuplicatesIn(int[] arr) {
    int startIndex = 0;
    int endIndex = arr.length - 1;

    while (startIndex <= endIndex) {
      int midIndex = startIndex + (endIndex - startIndex) / 2;
      // 4 cases
      if (midIndex < endIndex && arr[midIndex] > arr[midIndex + 1]) {
        return midIndex;
      }
      if (midIndex > startIndex && arr[midIndex] < arr[midIndex - 1]) {
        return midIndex - 1;
      }
      if (arr[midIndex] <= arr[startIndex]) {
        endIndex = midIndex - 1;
      } else {
        startIndex = midIndex + 1;
      }
    }
    return -1;
  }

  private static int binarySearchOrderAgnostic(
      int[] sortedArray, int sIndex, int eIndex, int target) {
    if (sortedArray == null || sortedArray.length == 0) {
      return -1;
    }
    // means ascending + all duplicate values
    boolean isAscending = (sortedArray[0] <= sortedArray[sortedArray.length - 1]);
    while (sIndex <= eIndex) {
      int mid = sIndex + (eIndex - sIndex) / 2;
      if (target == sortedArray[mid]) {
        return mid;
      } else if (target < sortedArray[mid]) {
        if (isAscending) {
          eIndex = mid - 1;
        } else {
          sIndex = mid + 1;
        }
      } else {
        if (isAscending) {
          sIndex = mid + 1;
        } else {
          eIndex = mid - 1;
        }
      }
    }
    return -1;
  }

  public static int findPivotWithDuplicatesIn(int[] arr) {
    int startIndex = 0;
    int endIndex = arr.length - 1;

    while (startIndex <= endIndex) {
      int midIndex = startIndex + (endIndex - startIndex) / 2;

      // 4 cases to check whether the element is pivot or not
      if (midIndex < endIndex && arr[midIndex] > arr[midIndex + 1]) {
        return midIndex;
      }
      if (midIndex > startIndex && arr[midIndex] < arr[midIndex - 1]) {
        return midIndex - 1;
      }

      // if the elements at the middle, start and end are equal then just skip the duplicates
      // example: [2,9,2,2,2]
      if (arr[midIndex] == arr[startIndex] && arr[midIndex] == arr[endIndex]) {
        // skip the duplicates
        // What if these elements at start and end were the pivot ??
        // example : [9,9,9,9,9,9,10,1,9]  and [9,10,1,9,9,9,9,9,9]     here start ==end ==mid and
        // check if start is pivot   ex: [9,1,9,9,9]
        if (arr[startIndex] > arr[startIndex + 1]) {
          return startIndex;
        }
        startIndex++;

        // check whether end is pivot or not , ex [1,1,1,9,1]
        if (arr[endIndex] < arr[endIndex - 1]) {
          return endIndex - 1;
        }
        endIndex--;
      }
      // if left is sorted , then pivot should be in right
      else if (arr[startIndex] < arr[midIndex]
          || (arr[startIndex] == arr[midIndex] && arr[endIndex] < arr[midIndex])) {
        startIndex = midIndex + 1;
      } else {
        endIndex = midIndex - 1;
      }
    }
    return -1;
  }
  // Find number of rotation count in rotated sorted array !!
  // find pivot element index
  // add +1 into that index
  // here is the answer
  public static int findRotationCounts(int[] arr) {
    //        int pivotIndex=findPivotWithDuplicatesIn(arr);
    //        if(pivotIndex==-1){
    //            return 0;
    //        }
    //        return pivotIndex+1;
    //        OR

    return findPivotWithDuplicatesIn(arr) + 1;
  }
}
