package org.practice.sorting;

import java.util.Arrays;

public class InsertionSort {

  // TC worst case O(n^2)
  // Adaptive ,stable ,takes less time when elements are already sorted order
  public static void runInsertionSort() throws Exception {
    int[] arr = {5, 1, 2, 4, 3, 0};
    insertionSortAsc(arr);
    System.out.println(Arrays.toString(arr));
  }

  // Sort the existing array using Insertion Sort
  // It considers the first element as sorted element  and now inserts the other element into it by
  // comparing it
  // TC- WorstCase O(n^2) when the array is  desc sorted i.e. [5,4,3,2,1,0]
  // TC- BestCase O(n) when the array is asc sorted i.e. [0,1,2,3,4]

  public static void insertionSortAsc(int[] arr) throws Exception {
    if (arr == null || arr.length == 0) {
      throw new Exception();
    }

    for (int pass = 1; pass < arr.length; pass++) {
      // OR  pass =  arr.length - 1; pass >0 ; pass--
      // now start comparing it with sorted element array
      // start from the last element
      for (int j = pass; j > 0; j--) {
        if (arr[j] < arr[j - 1]) {
          swap(arr, j, j - 1);
        } else {
          break;
        }
      }
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
