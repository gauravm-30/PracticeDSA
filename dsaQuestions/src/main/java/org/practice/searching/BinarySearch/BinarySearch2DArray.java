package org.practice.searching.BinarySearch;

import java.util.Arrays;

public class BinarySearch2DArray {
  // Now we need to understand the sorted 2D array
  // Lets say a matrix or 2D array is sorted in row-wise and column wise manner means every row as
  // well as every column is sorted
  // and I need to search the target element
  // when you have to search something in a large search space then try to minimize the search space
  // Consider n*n  or n*m matrix
  public static void performSearchOn2DArray() {

    // row and column wise sorted
    int[][] arr = {{10, 20, 30, 40}, {15, 25, 35, 45}, {28, 29, 37, 49}, {33, 34, 38, 50}};

    int[][] arr2 = {{10, 20, 30}, {15, 25, 35}, {28, 29, 37}, {33, 34, 38}};

    System.out.println(Arrays.toString(searchInRowAndColumnWiseSorted(arr2, 37)));

    // strictly sorted array(consist the column wise and row wise sorted array in it )
    int[][] strictSortedArray = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
    };
    System.out.println(Arrays.toString(searchInSorted(arr, 8)));
  }

  // matrix is sorted in row wise and column wise
  // can only work on n*m or m*m matrix with all elements into it .
  public static int[] searchInRowAndColumnWiseSorted(int[][] matrix, int target) {
    int row = 0; // starting point of the row
    int col = 0;
    if (matrix[0].length != 0) {
      col = matrix[0].length - 1; // starting point of the column, it can be n*m matrix also
    }
    // starting point of the column, it can be n*m matrix also
    while (row < matrix.length && col >= 0) {
      if (matrix[row][col] == target) {
        return new int[] {row, col};
      } else if (matrix[row][col] < target) {
        row++;
      } else {
        col--;
      }
    }
    return new int[] {-1, -1};
  }
  // Since we know that array is sorted ,it can be visualized as the sorted 1-D array
  // for more info watch codeStoryWithMIK
  // also we can use the formula to map to 1D array into the 2D array
  // we consider the matrix of n*m
  // note that it should be matrix
  public static int[] searchInSorted(int[][] matrix, int target) {
    int totalRow = matrix.length;
    int totalCols = 0;
    if (matrix[0].length != 0) {
      totalCols = matrix[0].length;
    }
    // using the 2D array mapping into the 1D array
    int startIndex = 0;
    int endIndex = totalRow * totalCols - 1;

    while (startIndex <= endIndex) {
      // using mid index find the row and column of 2D matrix
      int midIndex = startIndex + (endIndex - startIndex) / 2;

      int row = midIndex / totalCols; // mapping of row of 2D array
      int col = midIndex % totalCols; // mapping of column of 2D array
      if (matrix[row][col] == target) {
        return new int[] {row, col};
      } else if (target < matrix[row][col]) {
        endIndex = midIndex - 1;
      } else {
        startIndex = midIndex + 1;
      }
    }
    return new int[] {-1, -1};
  }
}
