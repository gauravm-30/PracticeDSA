package org.practice.searching.LinearSearch;

public class LinearSearchInt {
  public static void runLinearSearch() {
    int[] arr = getArray();
    int target = 5;
    System.out.println(linearSearchReturnIndex(arr, target));
  }

  private static int[] getArray() {
    return new int[] {5, 1, 2, 8, 0, 3};
  }

  // TC- O(n),Beacuse in the worst scenario it may take n comparison to find whether element is
  // present or not .
  // SC- O(1), as no extra space is required for it .
  public static int linearSearchReturnIndex(int[] arr, int target) {
    if (arr == null || arr.length == 0) {
      // ideally we should throw an exception here
      return -1;
    }

    for (int i = 0; i < arr.length; i++) {
      if (target == arr[i]) {
        return i;
      }
    }
    // this line will only execute if none of the return statements above have executed
    return -1;
  }

  // Return the element itself
  public static int linearSearchReturnElement(int[] arr, int target) {
    if (arr == null || arr.length == 0) {
      // ideally we should throw an exception here
      return Integer.MAX_VALUE;
    }

    for (int i = 0; i < arr.length; i++) {
      if (target == arr[i]) {
        return target;
      }
    }
    return Integer.MAX_VALUE;
  }

  // just check whether the element is present or not.
  public static boolean linearSearchReturnBoolean(int[] arr, int target) {
    if (arr == null || arr.length == 0) {
      // ideally we should throw an exception here
      return false;
    }

    for (int i = 0; i < arr.length; i++) {
      if (target == arr[i]) {
        return true;
      }
    }
    return false;
  }
}
