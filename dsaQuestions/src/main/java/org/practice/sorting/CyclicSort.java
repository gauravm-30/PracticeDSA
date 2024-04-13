package org.practice.sorting;

import java.util.Arrays;

public class CyclicSort {

  public static void runCyclicSort() throws Exception {
    int[] arr = {5, 1, 2, 4, 3, 0};
    cyclicSortAsc(arr);
    System.out.println(Arrays.toString(arr));
  }

  // Keep in mind that whenever ranges come into the picture apply cyclic sort.
  // It uses the index to sort the number.
  // It checks whether the element is on its correct index or not .
  // Given first n natural numbers like this.
  // when numbers are between from range 1 to N. use cyclic sort
  // TC O(N) - (N-1) swaps + N checks

  // Speciality of this alogrithm is that if the element are in range [1,n] or [0,n] and some
  // numbers are missing then , other numbers which are present and are in arr.length range will be
  // sorted ,which help finding the missing numbers
  public static void cyclicSortAsc(int[] arr) {
    int i = 0;
    while (i < arr.length) {
      int correctIndex = arr[i] - 1; // correct index of arr[i] element
      // if element is at correct index then i ==correctIndex
      if (arr[i] != arr[correctIndex]) {
        swap(arr, i, correctIndex);
      } else {

      }
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
