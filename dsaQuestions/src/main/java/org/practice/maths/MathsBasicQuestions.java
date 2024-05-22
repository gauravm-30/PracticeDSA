package org.practice.maths;

public class MathsBasicQuestions {

  // Given two numbers, find the Greatest Common Divisor (or Highest common factor)
  private static int gcd(int num1, int num2) {
    int minNum = Math.min(num1, num2);
    for (int i = minNum; i >= 1; i--) {
      if (num1 % i == 0 && num2 % i == 0) {
        return i;
      }
    }
    return 1;
  }
}
