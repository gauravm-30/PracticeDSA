package org.practice.recursion;

import java.util.ArrayList;
import java.util.List;

public class RecursionArrayProblems {
  // Question1: Check whether the array is sorted or not using recursion
  private static boolean isSorted(int[] arr) {
    int currIndex = 0;
    return isSortedHelperV1(arr, currIndex);
  }

  // approach 1
  private static boolean isSortedHelperV1(int[] arr, int currIndex) {
    if (currIndex == arr.length - 1) {
      return true;
    }
    if (arr[currIndex] > arr[currIndex + 1]) {
      return false;
    }
    return isSortedHelperV1(arr, currIndex + 1);
  }

  // approach 2
  private static boolean isSortedHelperV2(int[] arr, int currIndex) {
    if (currIndex == arr.length - 1) {
      return true;
    }
    return (arr[currIndex] <= arr[currIndex + 1]) && isSortedHelperV2(arr, currIndex + 1);
  }

  // Question2.1: Find the target element in unsorted array using recursion and if found return true
  // or false
  private static boolean search(int[] arr, int target) {
    int currIndex = 0;
    return searchHelperV1(arr, target, currIndex);
  }

  private static boolean searchHelperV1(int[] arr, int target, int currIndex) {
    if (currIndex == arr.length) {
      return false;
    }
    if (target == arr[currIndex]) {
      return true;
    }
    return searchHelperV1(arr, target, currIndex + 1);
  }

  private static boolean searchHelperV2(int[] arr, int target, int currIndex) {
    if (currIndex == arr.length) {
      return false;
    }
    return (target == arr[currIndex]) || searchHelperV1(arr, target, currIndex + 1);
  }

  // Question2.2: Find the target element in unsorted array using recursion and if found return
  // index
  // if found
  private static int searchIndex(int[] arr, int target) {
    int currIndex = 0;
    return searchIndexHelper(arr, target, currIndex);
  }

  private static int searchIndexHelper(int[] arr, int target, int currIndex) {
    if (currIndex == arr.length) {
      return -1;
    }
    if (target == arr[currIndex]) {
      return currIndex;
    }
    return searchIndexHelper(arr, target, currIndex + 1);
  }

  // Very Important pattern i.e. returning the arrayList from the lowest function call.
  // Since each reference variable is pointing to the same array object. So if any reference will
  // change the object will reflect in all other references also.

  // Question3: Find the target element which appears more than once  in unsorted array using
  // recursion and return all  indexes
  private static List<Integer> searchAllIndexes(int[] arr, int target) {
    List<Integer> elementIndexes = new ArrayList<>();
    int currIndex = 0;
    return searchAllIndexesHelper(arr, target, currIndex, elementIndexes);
  }

  private static List<Integer> searchAllIndexesHelper(
      int[] arr, int target, int currIndex, List<Integer> elementIndexes) {
    if (currIndex == arr.length) {
      // At last it returns the elementIndexes to the previous call. Since each of the reference in
      // below calls who updated the elementIndexes will be reflected to above ref. variables
      return elementIndexes;
    }
    if (target == arr[currIndex]) {
      elementIndexes.add(currIndex);
    }
    return searchAllIndexesHelper(arr, target, currIndex + 1, elementIndexes);
  }

  // Now Suppose I want to pass the list in the parameter .Then we have to make the list in the
  // body. Everytime function make the recursion call, It will again create the new list
  // Problem is how answer from below recursive call can be appended into the above calls.
  // Simple solution is to append the list from below call while returning.
  private static List<Integer> searchAllIndexesV2(int[] arr, int target) {
    // we can provide the value directly.
    return searchAllIndexesHelperV2(arr, target, 0);
  }

  private static List<Integer> searchAllIndexesHelperV2(int[] arr, int target, int currIndex) {
    List<Integer> list = new ArrayList<>();
    if (currIndex == arr.length) {
      return list;
    }
    if (target == arr[currIndex]) {
      list.add(currIndex);
    }
    List<Integer> resultFromBelowCalls = searchAllIndexesHelperV2(arr, target, currIndex + 1);
    list.addAll(resultFromBelowCalls);
    return list;
  }

  // Question 4: Search the target element in rotated sorted Array recursively
  private static int searchInRotatedArray(int[] arr, int target, int sIndex, int eIndex) {
    if (sIndex > eIndex) {
      return -1;
    }
    int mIndex = sIndex + (eIndex - sIndex) / 2;
    // Case 1
    if (target == arr[mIndex]) {
      return mIndex;
    }
    // Case 2
    if (arr[sIndex] <= arr[mIndex]) {
      // Case 2.1
      if (target >= arr[sIndex] && target < arr[mIndex]) {
        return searchInRotatedArray(arr, target, sIndex, mIndex - 1);
      } else {
        // Case 2.2
        return searchInRotatedArray(arr, target, mIndex + 1, eIndex);
      }
    }
    // Case 3
    else {
      // Case 3.1
      if (target > arr[mIndex] && target <= arr[eIndex]) {
        return searchInRotatedArray(arr, target, mIndex + 1, eIndex);
      } else {
        // Case 3.2
        return searchInRotatedArray(arr, target, sIndex, mIndex - 1);
      }
    }
  }
}
