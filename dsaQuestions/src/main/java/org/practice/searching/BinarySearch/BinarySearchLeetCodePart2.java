package org.practice.searching.BinarySearch;

public class BinarySearchLeetCodePart2 {

  // Problem 1 : https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
  // Problem 2 :  https://leetcode.com/problems/find-peak-element/description/
  //   1. Peak index in mountain array/bitonic array
  //   2. Given an integer array nums , find a peak element and return its index.
  //   3. If the array contains multiple peaks , then return the index of any of the peaks.
  public static int peakIndexInMountainArray(int[] mountainArr) {
    int sIndex = 0;
    int eIndex = mountainArr.length - 1;

    // here we haven't used startIndex<=endIndex because if both are equal and
    // the array is ascending order then at last start=mid=endIndex will pont to last
    // element of the  array and at that time we cannot apply the check of midIndex and midIndex+1
    while (sIndex < eIndex) {
      int mid = sIndex + (eIndex - sIndex) / 2;
      if (mountainArr[mid] > mountainArr[mid + 1]) {
        // you are in dec part of the array
        // this may be the ans but look at the  left
        // that's why endIndex != midIndex -1;
        eIndex = mid;
      } else {
        sIndex = mid + 1;
      }
    }
    // at the end, start and end will both point to the largest element
    // or return start
    return eIndex;
  }

  // Problem 3 : https://leetcode.com/problems/find-in-mountain-array/description/
  // Find the target element in mountain array  and return its index
  // if not found then return -1 ;
  public static int findInMountainArray(int[] mountainArr, int target) {
    int peakElementIndex = peakIndexInMountainArray(mountainArr);
    int firstTry = binarySearchOrderAgnostic(mountainArr, 0, peakElementIndex, target);
    if (firstTry != -1) {
      return firstTry;
    }

    return binarySearchOrderAgnostic(
        mountainArr, peakElementIndex + 1, mountainArr.length - 1, target);
  }

  private static int binarySearchOrderAgnostic(
      int[] mountainArr, int sIndex, int eIndex, int target) {

    /*
     * to detect whether the array is ascending sorted or descending sorted
     * best possible values to select are first and last
     * for ex {3,3,3,3,3,5,6} here first and last value should be selected to detect the order
     * */
    boolean isAscending = mountainArr[sIndex] <= mountainArr[eIndex];
    while (sIndex <= eIndex) {
      int mid = sIndex + (eIndex - sIndex) / 2;
      if (target == mountainArr[mid]) {
        return mid;
      } else if (target < mountainArr[mid]) {
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
}
