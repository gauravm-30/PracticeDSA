package org.practice.searching.BinarySearch;

public class BinarySearchInt {

  public static void runBinarySearch() {
    /*
     * Why non-duplicate ?
     * it will work on duplicate elements also but you cannot expect the
     * same index if the number of repeated numbers increase.
     * */
    int[] sortedArrayAsc = {1, 3, 7, 9, 10, 12, 16, 19};
    int[] sortedArrayDesc = {19, 16, 12, 10, 9, 7, 3, 1};

    int target = -1;
    System.out.println(binarySearchAsc(sortedArrayAsc, target));
    System.out.println(binarySearchDesc(sortedArrayDesc, target));
  }

  // returns the index
  // Note:Every time when we search and didn't get the require element we basically reduce the
  // search space
  // Given that array is sorted in ascending order
  private static int binarySearchAsc(int[] sortedArrayAsc, int target) {
    if (sortedArrayAsc == null || sortedArrayAsc.length == 0) {
      return -1;
    }
    return binarySearchWithRangeAsc(sortedArrayAsc, 0, sortedArrayAsc.length - 1, target);
  }

  private static int binarySearchWithRangeAsc(
      int[] sortedArrayAsc, int sIndex, int eIndex, int target) {
    while (sIndex <= eIndex) {
      int mid = sIndex + (eIndex - sIndex) / 2;
      if (target == sortedArrayAsc[mid]) {
        return mid;
      } else if (target < sortedArrayAsc[mid]) {
        eIndex = mid - 1;
      } else {
        sIndex = mid + 1;
      }
    }
    return -1;
  }

  // return the index
  // given that array is already sorted in desc order
  private static int binarySearchDesc(int[] sortedArrayDesc, int target) {
    if (sortedArrayDesc == null || sortedArrayDesc.length == 0) {
      return -1;
    }
    return binarySearchWithRangeDesc(sortedArrayDesc, 0, sortedArrayDesc.length - 1, target);
  }

  private static int binarySearchWithRangeDesc(
      int[] sortedArrayDesc, int sIndex, int eIndex, int target) {
    while (sIndex <= eIndex) {
      int mid = sIndex + (eIndex - sIndex) / 2;
      if (target == sortedArrayDesc[mid]) {
        return mid;
      } else if (target < sortedArrayDesc[mid]) {
        sIndex = mid + 1;
      } else {
        eIndex = mid - 1;
      }
    }
    return -1;
  }

  // order agnostic means array is sorted ,but we don't know whether it is in ascending order or
  // descending order.
  private static int binarySearchOrderAgnostic(int[] sortedArray, int target) {
    if (sortedArray == null || sortedArray.length == 0) {
      return -1;
    }
    if (sortedArray[0] <= sortedArray[sortedArray.length - 1]) {
      // means order is ascending
      return binarySearchWithRangeAsc(sortedArray, 0, sortedArray.length - 1, target);
    } else {
      // means order is descending
      return binarySearchWithRangeDesc(sortedArray, 0, sortedArray.length - 1, target);
    }
  }

  private static int binarySearchOrderAgnosticV2(int[] sortedArray, int target) {
    if (sortedArray == null || sortedArray.length == 0) {
      return -1;
    }
    // means ascending + all duplicate values
    boolean isAscending = (sortedArray[0] <= sortedArray[sortedArray.length - 1]);
    int sIndex = 0;
    int eIndex = sortedArray.length - 1;
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
}
