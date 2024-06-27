package org.practice.maths;

public class ReverseNumber {
  public static void main(String[] args) {
    int number = -29;
    System.out.println(reverseNumber(number));
  }

  private static int reverseNumber(int num) {
    int reverse = 0;
    while (num != 0) {
      int rem = num % 10;
      // Extra check to prevent overflow
      if (reverse == Integer.MAX_VALUE && rem > 7) return 0;
      if (reverse == Integer.MIN_VALUE && rem < -8) return 0;

      reverse = reverse * 10 + rem;
      num = num / 10;
    }
    return reverse;
  }
}
