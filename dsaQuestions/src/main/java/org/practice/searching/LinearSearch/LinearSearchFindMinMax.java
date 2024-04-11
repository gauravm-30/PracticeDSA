package org.practice.searching.LinearSearch;

public class LinearSearchFindMinMax {

  public static int findMin(int[] arr) {
    if (arr == null || arr.length == 0) {
      // ideally we should throw an exception here
      return Integer.MAX_VALUE;
    }
    int min = arr[0];
    for (int index = 1; index < arr.length; index++) {

      if (min > arr[index]) {
        min = arr[index];
      }
    }
    return min;
  }

  // or assume arr.length!=0 then first condition is not required anymore
  public static int findMax(int[] arr) {
    if (arr == null || arr.length == 0) {
      // ideally we should throw an exception here
      return Integer.MIN_VALUE;
    }
    int max = arr[0];
    for (int index = 1; index < arr.length; index++) {

      if (max < arr[index]) {
        max = arr[index];
      }
    }
    return max;
  }
}
