package org.practice.recursion;

public class RecusionLeetcodeProblems {

  // Problem 1 : Count number of steps to reduce to zero
  //    https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/description/

  private static int numberOfSteps(int num) {

    int count = 0;
    return numberOfStepsHelper(num, count);

    // Or we can write like this
    // return numberOfStepsHelper(num, 0);
  }

  private static int numberOfStepsHelper(int num, int count) {
    if (num == 0) {
      return count;
    }
    if (num % 2 == 0) {
      return numberOfStepsHelper(num / 2, count + 1);
    }
    return numberOfStepsHelper(num - 1, count + 1);
  }
}
