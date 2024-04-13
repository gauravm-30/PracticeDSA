package org.practice.sorting;

import java.util.Arrays;

public class BubbleSort {

  public static void runBubbleSort() throws Exception {
    int[] arr = {5, 1, 2, 4, 3, 0};
    bubbleSortAsc(arr);
    System.out.println(Arrays.toString(arr));
  }

  // Sort the existing array using Bubble Sort
  // It says take two elements at a time and swap if required!!
  // TC- WorstCase O(n^2) when the array is  desc sorted i.e. [5,4,3,2,1,0]
  // TC- BestCase O(n) when the array is asc sorted i.e. [0,1,2,3,4]

  // Observation : After every pass, we get the largest element.
  // means after K passes , we get the k largest element
  public static void bubbleSortAsc(int[] arr) throws Exception {
    if (arr == null || arr.length == 0) {
      throw new Exception();
    }

    for (int pass = 0; pass < arr.length - 1; pass++) {
      // OR  pass =  arr.length - 1; pass >0 ; pass--
      boolean isSwapped = false;
      for (int j = 0; j < (arr.length - 1) - pass; j++) {
        // j=0 j<pass j++
        if (arr[j] > arr[j + 1]) {
          swap(arr, j, j + 1);
          isSwapped = true;
        }
      }
      if (!isSwapped) {
        return; // or break;
      }
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
