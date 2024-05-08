package org.practice.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortedArrays {

  public static void runMergeTwoSortedArrays() {
    int[] sortedArr1 = {1, 4, 7, 10, 13, 16, 19};
    int[] sortedArr2 = {2, 5, 8, 9, 12, 15};
    int[] mergedArr = mergeArrays(sortedArr1, sortedArr2);

    // Using Stream APIs
    Arrays.stream(mergedArr).boxed().forEach(System.out::println);

    // using for loop
    List<Integer> integerList = new ArrayList<>(mergedArr.length);
    for (int i = 0; i < mergedArr.length; i++) {
      integerList.add(mergedArr[i]);
    }
  }

  private static int[] mergeArrays(int[] sortedArr1, int[] sortedArr2) {
    int size = sortedArr1.length + sortedArr2.length;
    int[] mergedArr = new int[size]; // by default all values are zeroes
    int i = 0, j = 0, k = 0;

    // when both arrays have elements
    while (i < sortedArr1.length && j < sortedArr2.length) {
      if (sortedArr1[i] < sortedArr2[j]) {
        mergedArr[k++] = sortedArr1[i++];
      } else {
        mergedArr[k++] = sortedArr2[j++];
      }
    }

    // when only sortedArray1 left
    while (i < sortedArr1.length) {
      mergedArr[k++] = sortedArr1[i++];
    }

    // when only sortedArray2 left
    while (j < sortedArr2.length) {
      mergedArr[k++] = sortedArr2[j++];
    }
    return mergedArr;
  }
}
