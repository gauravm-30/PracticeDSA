package org.practice.searching.LinearSearch;

public class LinearSearchInRange {
  public static void runLinearSearch() {
    int[] arr = getArray();
    int target = 5;
    System.out.println(linearSearchInRangeReturnIndex(arr, target, 2, 5));
  }

  private static int linearSearchInRangeReturnIndex(int[] arr, int target, int start, int end) {
    if (arr == null || arr.length == 0) {
      // ideally we should throw an exception here
      return -1;
    }

    for (int index = start; index <= end; index++) {
      if (target == arr[index]) {
        return index;
      }
    }
    // this line will only execute if none of the return statements above have executed
    return -1;
  }

  private static int[] getArray() {
    return new int[] {5, 1, 2, 8, 0, 3};
  }
}
