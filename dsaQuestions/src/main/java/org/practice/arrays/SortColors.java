package org.practice.arrays;

import java.util.Arrays;

// https://leetcode.com/problems/sort-colors/description/
public class SortColors {
  public static void main(String[] args) {
    int[] sortColorsArr = {2, 2, 1, 1, 0, 1, 2, 0};

    sortColors(sortColorsArr);
    System.out.println("Arrays.toString(sortColorsArr) = " + Arrays.toString(sortColorsArr));
  }

  // Approach 1 sort the array using Arrays.sort()
  // TC-O(NlogN)

  // Approach 2 take the three variables to count the frequency of 0s, 1s and 2s and then again run
  // the loop to insert 0s 1s and 2s one by one
  // TC - O (N+ N)

  // Approach 3
  // O(N)
  private static void sortColors(int[] sortColorsArr) {
    int n = sortColorsArr.length;
    int i = 0; // denotes the 0
    int j = 0; // denotes the 1
    int k = n - 1; // denotes the 2  ,it will be at the last

    while (j <= k) {
      if (sortColorsArr[j] == 1) {
        j++;
      } else if (sortColorsArr[j] == 2) {
        swap(sortColorsArr, j, k);
        k--;
      } else { // sortColorsArr[j] == 0
        swap(sortColorsArr, i, j);
        i++;
        j++;
      }
    }
  }

  private static void swap(int[] arr, int j, int k) {
    int temp = arr[j];
    arr[j] = arr[k];
    arr[k] = temp;
  }
}
