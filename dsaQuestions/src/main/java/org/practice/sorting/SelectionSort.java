package org.practice.sorting;

import java.util.Arrays;

public class SelectionSort {

  public static void runSelectionSort() throws Exception {
    int[] arr = {5, 1, 2, 4, 3, 0};
    selectionSortAsc(arr);
    System.out.println(Arrays.toString(arr));
  }

  // Sort the existing array using Selection Sort
  // Idea is we select the element (either minimum or maximum every time) and place that element on
  // its correct position
  // TC- WorstCase O(n^2) when the array is  desc sorted i.e. [5,4,3,2,1,0]
  // TC- BestCase O(n^2) when the array is asc sorted i.e. [0,1,2,3,4]

  // Observation : After every pass, we get the minimum element.
  // means after K passes , we get the k minimum element
  // Stable No

  public static void selectionSortAsc(int[] arr) throws Exception {
    if (arr == null || arr.length == 0) {
      throw new Exception();
    }
    // lets say we are going to select the min element always

    for (int pass = 0; pass < arr.length - 1; pass++) {
      int minValueIndex = findMinFrom(arr, pass);
      swap(arr, pass, minValueIndex);
    }
  }

  private static int findMinFrom(int[] arr, int startIndex) {
    int min = startIndex;
    for (int i = startIndex; i < arr.length; i++) {
      if (arr[min] > arr[i]) {
        min = i;
      }
    }
    return min;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
