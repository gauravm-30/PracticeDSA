package org.practice.recursion;

public class RecursionPatternsProblems {
  /*
   *      * * * *
   *      * * *
   *      * *
   *      *
   * */
  public static void printPatternV1(int n) {
    printPatternHelperV1(n, 0);
  }

  private static void printPatternHelperV1(int row, int col) {
    if (row == 0) {
      return;
    }
    if (row > col) {
      System.out.print("* ");
      printPatternHelperV1(row, col + 1);
    } else {
      System.out.println();
      printPatternHelperV1(row - 1, 0);
    }
  }

  /*
   *      *
   *      * *
   *      * * *
   *      * * * *
   * */
  public static void printPatternV2(int n) {
    printPatternHelperV2(n, 0);
  }

  private static void printPatternHelperV2(int row, int col) {
    if (row == 0) {
      return;
    }
    if (row > col) {
      printPatternHelperV2(row, col + 1);
      System.out.print("* ");
    } else {
      printPatternHelperV2(row - 1, 0);
      System.out.println();
    }
  }
}
