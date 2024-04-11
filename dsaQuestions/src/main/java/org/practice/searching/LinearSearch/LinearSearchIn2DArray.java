package org.practice.searching.LinearSearch;

public class LinearSearchIn2DArray {
  public static void performLinearSearchOnIntIn2DArr() {
    /*
     * Array of arrays = 2D array
     * total number of arrays(rows) in 2D array= arr.length
     * total number of elements(columns) in each array of the 2D array = arr[0].length
     * int[][] arr={{},{},{}}; valid 2D array and  has arr.length=3 and arr.length[0].length=0
     * */
    int[][] empty2DArr = {{}, {}, {}}; // here arr.length==3
    int[][] empty2DArr2 = {}; // here arr.length==0
    int[][] arr = {{-5, 5}, {-3, 4, 0}, {1, 9, 3}, {}};
    int target = 0;

    int max = findMaxIn2DArr(arr);
    int[] position = linearSearchOnIntIn2DArr(arr, 4);
    //        System.out.println("Position of the element in 2D array: "+
    // Arrays.toString(position));
    System.out.println("Max in 2D array: " + max);
  }

  private static int[] linearSearchOnIntIn2DArr(int[][] arr, int target) {
    if (arr == null || arr.length == 0) {
      return new int[] {-1, -1};
    }

    for (int row = 0; row < arr.length; row++) {
      // check whether the each row length is not euqal to zero
      if (arr[row].length != 0) {
        for (int col = 0; col < arr[row].length; col++) {
          int element = arr[row][col];
          return new int[] {row, col};
        }
      }
    }
    return new int[] {-1, -1};
  }

  public static int findMaxIn2DArr(int[][] arr) {
    int max = Integer.MIN_VALUE;
    if (arr == null || arr.length == 0) {
      return max;
    }

    for (int row = 0; row < arr.length; row++) {
      // check whether the each row length is not equal to zero
      if (arr[row].length != 0) {
        for (int col = 0; col < arr[row].length; col++) {
          int element = arr[row][col];
          if (max < element) {
            max = element;
          }
        }
      }
    }
    return max;
  }
}
