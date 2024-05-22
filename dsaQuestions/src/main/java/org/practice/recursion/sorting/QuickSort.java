package org.practice.recursion.sorting;

public class QuickSort {
  // A utility function to print an array
  static void printArray(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; ++i) System.out.print(arr[i] + " ");
    System.out.println();
  }

  public static void main(String[] args) {
    int[] arr = {10, 7, 8, 9, 1, 5};
    int n = arr.length;
    QuickSort ob = new QuickSort();
    ob.sort(arr, 0, n - 1);
    System.out.println("Sorted array:");
    printArray(arr);
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
        //        swap(arr, sIndex, eIndex);
      }
    }
    return sIndex;
  }

  // This function takes the last element as the pivot, places the pivot element at its correct
  // position in the sorted array,
  // and places all smaller elements (smaller than the pivot) to the left of the pivot and all
  // greater elements to the right.
  int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = (low - 1);
    for (int j = low; j < high; j++) {
      // check the element with pivot and replace if required
      if (arr[j] <= pivot) {
        i++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

    // at this time replace the i+1 element with the pivot element
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    return i + 1;
  }

  // The main function that implements QuickSort
  void sort(int[] arr, int low, int high) {
    if (low < high) {
      int pi = partition(arr, low, high);
      sort(arr, low, pi - 1); // Before pi
      sort(arr, pi + 1, high); // After pi
    }
  }
}
