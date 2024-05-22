package org.practice.searching.BinarySearch;

// Clap Clap
// Observation : When target element is not found , at that time
// eIndex will point to element just smaller than the target element and sIndex will point to
// element just larger than then target element
public class FloorAndCeilOfNumber {
  public static void runFloorAndCeilOfNumber() {
    int[] sortedArrayAsc = {1, 3, 7, 9, 10, 12, 16, 19};
    int[] sortedArrayDesc = {19, 16, 12, 10, 9, 7, 3, 1};
    int target1 = 16;
    int target2 = 4;
    int[] duplicateSortedArrayAsc = {1, 3, 3, 7, 7, 7, 7, 7, 9, 10, 12, 16, 19};
    int[] duplicateSortedArrayDesc = {19, 16, 12, 10, 9, 7, 7, 7, 7, 7, 3, 3, 3, 1};

    System.out.println(
        "Floor of number, target exist " + floorOfNumberInAscSortedArray(sortedArrayAsc, target1));
    System.out.println(
        "Floor of number target, doesn't exist "
            + floorOfNumberInAscSortedArray(sortedArrayAsc, target2));
    System.out.println(
        "Strict floor of number, target exist"
            + strictFloorOfNumberInAscSortedArray(sortedArrayAsc, target1));
    System.out.println(
        "Strict floor of number target, doesn't exist "
            + strictFloorOfNumberInAscSortedArray(sortedArrayAsc, target2));
    System.out.println(
        "Ceil of number, target exist " + ceilOfNumberInAscSortedArray(sortedArrayAsc, target1));
    System.out.println(
        "Ceil of number target, doesn't exist "
            + ceilOfNumberInAscSortedArray(sortedArrayAsc, target2));
    System.out.println(
        "Strict Ceil of number, target exist "
            + strictCeilOfNumberInAscSortedArray(sortedArrayAsc, target1));
    System.out.println(
        "Strict Ceil of number target, doesn't exist "
            + strictCeilOfNumberInAscSortedArray(sortedArrayAsc, target2));
  }

  // return largest value smaller than or equal to the target element
  public static int floorOfNumberInAscSortedArray(int[] sortedArray, int target) {
    if (sortedArray == null || sortedArray.length == 0) {
      return Integer.MIN_VALUE;
    }
    return floorOfNumber(sortedArray, 0, sortedArray.length - 1, target);
  }

  // return largest value smaller than  the target element
  public static int strictFloorOfNumberInAscSortedArray(int[] sortedArray, int target) {
    if (sortedArray == null || sortedArray.length == 0) {
      return Integer.MIN_VALUE;
    }
    return strictFloorOfNumber(sortedArray, 0, sortedArray.length - 1, target);
  }

  private static int strictFloorOfNumber(int[] sortedArray, int sIndex, int eIndex, int target) {
    // case 1 when it has only one element
    if (target <= sortedArray[sIndex]) {
      return Integer.MIN_VALUE;
    }

    // Case 2  what if all elements are same and equal to target ,in such scenario strict floor and
    // ceil doesn't exist
    if (sortedArray[sIndex] == sortedArray[eIndex] && target == sortedArray[eIndex]) {
      return Integer.MIN_VALUE;
    }

    while (sIndex <= eIndex) {
      int mid = sIndex + (eIndex - sIndex) / 2;
      if (target == sortedArray[mid]) {
        // because if target is equal to mid element it means , strict floor will lie
        // on the left side in case of asc order
        eIndex = mid - 1;
      } else if (target < sortedArray[mid]) {
        eIndex = mid - 1;
      } else {
        sIndex = mid + 1;
      }

      /*if (target <= sortedArray[mid]) {
        eIndex = mid - 1;
      } else {
        sIndex = mid + 1;
      }*/
    }
    return sortedArray[eIndex];
  }

  private static int floorOfNumber(int[] sortedArray, int sIndex, int eIndex, int target) {
    // case 1 : When the target is less than the min element
    if (target < sortedArray[sIndex]) {
      return Integer.MIN_VALUE;
    }

    while (sIndex <= eIndex) {
      int mid = sIndex + (eIndex - sIndex) / 2;
      if (target == sortedArray[mid]) {
        return sortedArray[mid];
      } else if (target < sortedArray[mid]) {
        eIndex = mid - 1;
      } else {
        sIndex = mid + 1;
      }
    }
    return sortedArray[eIndex];
  }

  // return smallest value greater than or equal to the target element
  public static int ceilOfNumberInAscSortedArray(int[] sortedArray, int target) {
    if (sortedArray == null || sortedArray.length == 0) {
      return Integer.MAX_VALUE;
    }
    return ceilOfNumber(sortedArray, 0, sortedArray.length - 1, target);
  }

  // return smallest value smaller than  the target element
  public static int strictCeilOfNumberInAscSortedArray(int[] sortedArray, int target) {
    if (sortedArray == null || sortedArray.length == 0) {
      return Integer.MIN_VALUE;
    }
    return strictCeilOfNumber(sortedArray, 0, sortedArray.length - 1, target);
  }

  private static int strictCeilOfNumber(int[] sortedArray, int sIndex, int eIndex, int target) {
    // case 1 : When the array has only one element
    if (target >= sortedArray[eIndex]) {
      return Integer.MAX_VALUE;
    }
    while (sIndex <= eIndex) {
      int mid = sIndex + (eIndex - sIndex) / 2;
      if (target == sortedArray[mid]) {
        // because if target is equal to mid element it means , strict floor will lie
        // on the left side in case of asc order
        sIndex = mid + 1;
      } else if (target < sortedArray[mid]) {
        eIndex = mid - 1;
      } else {
        sIndex = mid + 1;
      }

      /*if (target <= sortedArray[mid]) {
        eIndex = mid - 1;
      } else {
        sIndex = mid + 1;
      }*/
    }
    return sortedArray[sIndex];
  }

  private static int ceilOfNumber(int[] sortedArray, int sIndex, int eIndex, int target) {
    // case 1 : When the array has only one element
    if (target > sortedArray[eIndex]) {
      return Integer.MAX_VALUE;
    }

    while (sIndex <= eIndex) {
      int mid = sIndex + (eIndex - sIndex) / 2;
      if (target == sortedArray[mid]) {
        return sortedArray[mid];
      } else if (target < sortedArray[mid]) {
        eIndex = mid - 1;
      } else {
        sIndex = mid + 1;
      }
    }
    return sortedArray[sIndex];
  }
}
