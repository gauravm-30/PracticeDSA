package org.practice.recursion;

import java.util.Arrays;

public class RecursionSortingProblems {
  public static void runSorting() {
    int[] arr = {4, 2, 7, 1, 0};
    //    bubbleSort(arr);
    //    mergeSort(arr, 0, arr.length - 1);
    int[] arr1 = {2, 7, 8, 9, 10};
    quickSort(arr1, 0, arr1.length - 1);
    //    selectionSort(arr);
    //    System.out.println(Arrays.toString(arr));

    System.out.println(Arrays.toString(arr1));
  }

  // Bubble Sort recursively
  private static void bubbleSort(int[] arr) {
    bubbleSortHelper(arr, 0, arr.length - 1);
  }

  private static void bubbleSortHelper(int[] arr, int sIndex, int eIndex) {
    if (eIndex == 0) {
      return;
    }
    if (sIndex < eIndex) {
      if (arr[sIndex] > arr[sIndex + 1]) {
        swap(arr, sIndex, sIndex + 1);
      }
      bubbleSortHelper(arr, sIndex + 1, eIndex);
    } else {
      bubbleSortHelper(arr, 0, eIndex - 1);
    }
  }

  // Bubble Sort recursively
  private static void selectionSort(int[] arr) {
    // Tip1: since we need to share to maxValueIndex with future recursion call so that they can
    // compare it with their current index value to check the maximum.
    selectionSortHelper(arr, 0, arr.length - 1, 0);
  }

  private static void selectionSortHelper(int[] arr, int sIndex, int eIndex, int maxValueIndex) {

    if (eIndex == 0) {
      return;
    }
    // means we are traversing the current row
    if (sIndex < eIndex) {
      if (arr[sIndex] > arr[maxValueIndex]) {
        maxValueIndex = sIndex;
      }
      selectionSortHelper(arr, sIndex + 1, eIndex, maxValueIndex);
    } else {
      // means sIndex have reached the eIndex value.
      swap(arr, maxValueIndex, sIndex);
      // restart with the nex row now and reset the sIndex eIndex and maxValue
      selectionSortHelper(arr, 0, eIndex - 1, 0);
    }
  }

  // mergeSort
  // Idea is to virtually divide and conquer  the arrays  and then merge the sorted arrays.
  // In this below merge sort original array is not being modified
  // TC- At every level N elements are being merged , so O(N) and it is happening logN times.So
  // O(NlogN)
  // Here even if array is sorted , it will go till the base condition but this is not case in quick
  // sort
  private static int[] mergeSortV1(int[] arr) {
    if (arr.length == 1) {
      return arr;
    }
    int mid = arr.length / 2;
    // Now new array is created and values from arr is being copied into it.
    int[] left = mergeSortV1(Arrays.copyOfRange(arr, 0, mid)); // mid is exclusive here
    int[] right =
        mergeSortV1(
            Arrays.copyOfRange(
                arr, mid, arr.length)); // mid is inclusive here , arr.length is exclusive
    return mergeV1(left, right);
  }

  // it is also returning the new array
  private static int[] mergeV1(int[] left, int[] right) {
    int i = 0;
    int j = 0;
    int k = left.length + right.length;
    int[] result = new int[k];

    while (i < left.length && j < right.length) {
      if (left[i] < right[j]) {
        result[k++] = left[i++];
      } else {
        result[k++] = right[j++];
      }
    }
    // it may possible that one of the arrays is not complete
    while (i < left.length) {
      result[k++] = left[i++];
    }

    while (j < right.length) {
      result[k++] = right[j++];
    }
    return result;
  }

  // We can do inplace merge sort also using indexes
  private static void mergeSort(int[] arr, int sIndex, int eIndex) {
    if (sIndex == eIndex) {
      return;
    }
    int mid = sIndex + (eIndex - sIndex) / 2;
    mergeSort(arr, sIndex, mid);
    mergeSort(arr, mid + 1, eIndex);
    merge(arr, sIndex, mid, eIndex);
  }

  private static void merge(int[] arr, int sIndex, int mid, int eIndex) {
    int i = sIndex, j = mid + 1;
    int[] result = new int[eIndex - sIndex + 1];
    int k = 0;
    while (i <= mid && j <= eIndex) {
      if (arr[i] < arr[j]) {
        result[k++] = arr[i++];
      } else {
        result[k++] = arr[j++];
      }
    }

    while (i <= mid) {
      result[k++] = arr[i++];
    }
    while (j <= eIndex) {
      result[k++] = arr[j++];
    }

    // Now copying the new array into the original  one.
    // Be careful while copying
    // Thing about the right part of array  also
    for (int l = sIndex, m = 0; m < result.length; l++, m++) {
      arr[l] = result[m];
    }
  }

  // Quick Sort
  // There is concept of pivot element
  // Pivot: is such element i.e. after first pass
  // all the element less than pivot should be on LHS of Pivot.
  // all the element greater than pivot should be on RHS of Pivot.
  // Ex Say pivot is 4 in [3,1,2,4,5] .Since pivot is 4 so element  LHS to it will be lesser than 4
  // and elements RHS to it will be greater than 4 .It also means pivot element is at its correct
  // index.

  // Important note : Even pivot position can be move forward or backward so that LHS<Pivot<RHS
  // How to choose pivot :
  // Random element OR corner element (either first or last) OR pick the middle
  // element

  // Recurrence Relation - TC = T(K) +T(N-K-1)+  O(N)
  // Worst case when the pivot is always the largest/ smallest -O(N^2)
  // Best case when the pivot is always middle -O(NLogN)

  // Merge Sort works better in linked list due to memory allocation , not in place and stable
  // Quick Sort not stable , In place

  // Quick Tip : If you wish to divide the array and manipulate it but don't want to create extra
  // array
  // use the indexes
  private static void quickSort(int[] arr, int sIndex, int eIndex) {
    if (sIndex >= eIndex) {
      return;
    }
    // we are going to take the pivot as mid element
    int mid = sIndex + (eIndex - sIndex) / 2;
    int pivot = arr[mid];
    int partitionIndex = partition(arr, sIndex, eIndex, pivot);
    // now my pivot is at correct index . please sort the two halves now
    quickSort(arr, sIndex, partitionIndex - 1);
    quickSort(arr, partitionIndex + 1, eIndex);
  }

  private static int partition(int[] arr, int sIndex, int eIndex, int pivot) {

    // if its is already sorted it will not swap
    while (sIndex < eIndex) {
      while (arr[sIndex] < pivot) {
        sIndex++;
      }
      while (arr[eIndex] > pivot) {
        eIndex--;
      }
      if (sIndex < eIndex) {
        swap(arr, sIndex, eIndex);
      }
    }
    return sIndex;
  }

  private static void swap(int[] arr, int currIndex, int nextIndex) {
    int temp = arr[nextIndex];
    arr[nextIndex] = arr[currIndex];
    arr[currIndex] = temp;
  }
}
