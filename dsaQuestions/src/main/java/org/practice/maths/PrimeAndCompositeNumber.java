package org.practice.maths;

public class PrimeAndCompositeNumber {

  // A prime number is a natural number greater than 1 that has no positive integer divisors
  // other than 1 and itself.
  // These numbers cannot be written as the product of two smaller natural numbers.
  // The numbers greater than 1 that are not prime are called composite numbers.
  // 1 is neither composite nor prime number .

  // TAP academy
  // Approach 1
  // Brute force Approach
  // TC O(N)
  public static boolean isPrime(int num) {
    // we should not start from 1 as it is the fact that it divides all the elements.
    // If we observe then largest factor  after the number itself is the number/2;
    // we need to run the loop just to n/2 only .
    for (int i = 2; i <= (num / 2); i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }

  // Approach 2
  // Just try to find the first the factor of the element
  // if you observe carefully, if the number is not prime then you will guaranteed find the  one of
  // the factor in between 2 and sqrt(n)
  // of the number
  // so we need go till sqrt(n) in loop.
  // TC O(sqrt(N))
  public static boolean isPrimeV2(int num) {
    for (int i = 2; i * i < num; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }

  // Approach 3
  // Based on observation
  // TC (sqrt(N)) but much more efficient than before .
  public static boolean isPrimeV3(int num) {
    if (num == 1) {
      return false;
    }
    // Case 2
    if (num == 2 || num == 3) {
      return true;
    }
    // Case 3
    if (num % 2 == 0 || num % 3 == 0) {
      return false;
    }
    // case 4
    for (int i = 5; i * i < num; i += 6) {
      if (num % i == 0 || num % (i + 2) == 0) {
        return false;
      }
    }
    return true;
  }
}
