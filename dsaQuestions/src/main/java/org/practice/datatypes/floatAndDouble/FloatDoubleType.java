package org.practice.datatypes.floatAndDouble;

public class FloatDoubleType {
  public static void main(String[] args) {
    //    floatAddOperation();
    //    floatSubstractionOperation();
    //    floatMultiplicationOperation();
    //    floatDivisionOperation();
    //    floatRemainderOperation();
    //    floatConversionUptoSpecificDecimalPlaces();
    //    floatInfinityOperation();
    //    compareFloats();
    //    comparingInfinity();
    comparingUsingThreesold();
  }

  private static void floatRemainderOperation() {
    float f1 = -1.2200f; // it becomes -1.22
    float f2 = 1.90f; // it becomes 1.9
    float f3 = f1 % f2; //
    System.out.println("f3 = " + f3);

    float f4 = 1.7f;
    float f5 = 1.7f;
    float f6 = f4 % f5; // result 0.0
    System.out.println("f6 = " + f6);

    float f7 = 1.7000f; // it becomes 1.7
    float f8 = 1.7f;
    float f9 = f7 % f8; // result = 0.0
    System.out.println("f9 = " + f9);

    float f10 = 1.7f;
    float f11 = 1.755f;
    float f12 = f10 % f11; // result 1.7
    System.out.println("f12 = " + f12);

    float f13 = 0.0000f; // becomes 0.0
    float f14 = 0.000f; // becomes 0.0
    float f15 = f13 % f14; //  output - Nan
    System.out.println("f15 = " + f15);

    float f16 = -13.00f; // becomes 0.0
    float f17 = 13f; // becomes 0.0
    float f18 = f16 % f17; //  output  -0.0
    System.out.println("f18 = " + f18);
  }

  private static void floatMultiplicationOperation() {
    float f1 = -1.2200f; // it becomes -1.22
    float f2 = 1.90f; // it becomes 1.9
    float f3 = f1 * f2; //  -2.318
    System.out.println("f3 = " + f3);

    float f4 = 1.7f;
    float f5 = 1.7f;
    float f6 = f4 * f5; // 2.89
    System.out.println("f6 = " + f6);

    float f7 = 1.7000f; // it becomes 1.7
    float f8 = 1.7f;
    float f9 = f7 * f8; // 2.89
    System.out.println("f9 = " + f9);

    float f10 = 1.7f;
    float f11 = 1.755f;
    float f12 = f10 * f11; // 2.9835
    System.out.println("f12 = " + f12);

    float f13 = 0.0000f; // becomes 0.0
    float f14 = 0.000f; // becomes 0.0
    float f15 = f13 * f14; // 0.0
    System.out.println("f15 = " + f15);
  }

  private static void floatDivisionOperation() {
    float f1 = -1.2200f; // it becomes -1.22
    float f2 = 1.90f; // it becomes 1.9
    float f3 = f1 / f2; //  result = -0.6421053
    System.out.println("f3 = " + f3);

    float f4 = 1.7f;
    float f5 = 1.7f;
    float f6 = f4 / f5; // result 1.0
    System.out.println("f6 = " + f6);

    float f7 = 1.7000f; // it becomes 1.7
    float f8 = 1.7f;
    float f9 = f7 / f8; // result = 1.0
    System.out.println("f9 = " + f9);

    float f10 = 1.7f;
    float f11 = 1.755f;
    float f12 = f10 / f11; // result 0.968661
    System.out.println("f12 = " + f12);

    float f13 = 0.0000f; // becomes 0.0
    float f14 = 0.000f; // becomes 0.0
    float f15 = f13 / f14; //  output - Nan
    System.out.println("f15 = " + f15);

    float f16 = 13.00f; // becomes 0.0
    float f17 = 13f; // becomes 0.0
    float f18 = f16 / f17; //  output - 1.0
    System.out.println("f18 = " + f18);
  }

  private static void floatConversionUptoSpecificDecimalPlaces() {
    float f1 = 1.90f;
    float f2 = 1.2200f;

    float f3 = f1 - f2;
    String formattedResult1 = String.format("%.2f", f3);
    float f3WithTwoDecimalPlaces = Float.parseFloat(formattedResult1);
    System.out.println("f3WithTwoDecimalPlaces = " + f3WithTwoDecimalPlaces);

    float f4 = f2 - f1;
    String formattedResult2 = String.format("%.2f", f4);
    float f4WithTwoDecimalPlaces = Float.parseFloat(formattedResult2);
    System.out.println("f4WithTwoDecimalPlaces = " + f4WithTwoDecimalPlaces);
  }

  private static void floatSubstractionOperation() {
    float f1 = -1.2200f; // it becomes -1.22
    float f2 = 1.90f; // it becomes 1.9
    float f3 = f1 + f2; // expected 0.68  but answer is 0.67999995
    System.out.println("f3 = " + f3);

    float f4 = 1.7f;
    float f5 = 1.7f;
    float f6 = f4 - f5; // 0.0
    System.out.println("f6 = " + f6);

    float f7 = 1.7000f; // it becomes 1.7
    float f8 = 1.7f;
    float f9 = f7 - f8; // 0.0
    System.out.println("f9 = " + f9);

    float f10 = 1.7f;
    float f11 = 1.755f;
    float f12 = f10 - f11; // expected -0.055 actual result= -0.054999948
    System.out.println("f12 = " + f12);

    float f13 = 0.0000f; // becomes 0.0
    float f14 = 0.000f; // becomes 0.0
    float f15 = f13 - f14; // 0.0
    System.out.println("f15 = " + f15);
  }

  private static void floatAddOperation() {
    float f1 = 1; // integral converted into 1.0
    float f2 = 2; // integral converted into 2.0

    float f3 = f1 + f2; // after adding it becomes 3.0
    System.out.println("f3 = " + f3);

    float f4 = 1.2f; // it becomes 1.2
    float f5 = 1.4f; // it becomes 1.4
    float f6 = f4 + f5; // it becomes 2.6
    System.out.println("f6 = " + f6);

    float f7 = 1.2200f; // it becomes 1.22
    float f8 = 1.90f; // it becomes 1.9
    float f9 = f7 + f8;
    System.out.println("f9 = " + f9); // 3.12
  }

  private static void floatInfinityOperation() {

    float f1 = (0.0f / 0.0f);
    System.out.println("f1 = " + f1); // gives NaN

    float f2 = -(0.0f / 0.0f);
    System.out.println("f2 = " + f2); // gives NaN

    float f3 = (1.0f / 0.0f);
    System.out.println(f3); // gives infinity

    float f4 = -(1.0f / 0.0f);
    System.out.println(f4); // gives -Infinity

    float f5 = 0.0f * (1.0f / 0.0f);
    System.out.println(f5); // gives NaN

    double d1 = (1.0 / 0.0);
    System.out.println(d1); // gives infinity

    double d2 = -(1.0 / 0.0);
    System.out.println(d2); // gives -infinity
  }

  private static void compareFloats() {

    // Not recommended way of comparison
    System.out.println(1.2f == 1.20f);
    System.out.println(1.2f == 1.2f);
    System.out.println(0.0f == -0.0f); // negative and positive zero are equal here

    System.out.println(1.2f > 1.2f);
    System.out.println(1.2f < 1.2f);
    System.out.println(1.2f != 1.2f);

    comparingDoubles();
  }

  private static void comparingDoubles() {

    // Here '==' fails
    // Not recommended to use it for comparing floating point integers
    // Method 1
    double f1 = .0;
    for (int i = 1; i <= 11; i++) {
      f1 += .1;
    }

    // Method 2
    double f2 = .1 * 11;

    System.out.println("f1 = " + f1);
    System.out.println("f2 = " + f2);

    if (f1 == f2) System.out.println("f1 and f2 are equal\n");
    else System.out.println("f1 and f2 are not equal\n");

    if (Double.compare(f1, f2) == 0) {
      System.out.println("Are equal");
    } else {
      System.out.println("Not Equal");
    }
  }

  private static void comparingInfinity() {
    double a = Double.POSITIVE_INFINITY;
    double b = Double.POSITIVE_INFINITY;

    // Below is always true as it is comparing the value of  a && b
    if (a == b) {
      System.out.println("'==' says a is equal to b");
    } else {
      System.out.println("'==' says a is not equal to b");
    }

    // Below will give NaN which will be stored in c and thus checking NaN < 0.0001 gives not equal
    // to
    double c = a - b;
    if (Math.abs(a - b) < 0.0001) {
      System.out.println("'THRESHOLD' based equality check says a is equal to b");
    } else {
      System.out.println("'THRESHOLD' based equality check says a is not equal to b");
    }
  }

  private static void comparingUsingThreesold() {
    final double THRESHOLD = .0001;

    // Method 1
    double f1 = .0;
    for (int i = 1; i <= 11; i++) {
      f1 += .1;
    }

    // Method 2
    double f2 = .1 * 11;

    System.out.println("f1 = " + f1);
    System.out.println("f2 = " + f2);

    if (Math.abs(f1 - f2) < THRESHOLD) System.out.println("f1 and f2 are equal using threshold\n");
    else System.out.println("f1 and f2 are not equal using threshold\n");
  }
}
