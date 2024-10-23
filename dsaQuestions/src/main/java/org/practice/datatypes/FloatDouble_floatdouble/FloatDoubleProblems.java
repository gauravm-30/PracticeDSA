package org.practice.datatypes.FloatDouble_floatdouble;

public class FloatDoubleProblems {
  public static void main(String[] args) {
    printMaxEle();
  }

  private static void printMaxEle() {
    double[] myList = {1, 5, 5, 5, 5, 1}; // {1.0,5.0,5.0,5.0,5.0,1.0}
    double max = myList[0];
    int indexOfMax = 0;
    for (int i = 1; i < myList.length; i++) {
      if (myList[i] > max) {
        max = myList[i];
        indexOfMax = i;
      }
    }
    System.out.println(indexOfMax);
  }
}
