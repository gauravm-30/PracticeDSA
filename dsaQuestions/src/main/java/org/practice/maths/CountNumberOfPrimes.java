package org.practice.maths;

import java.util.Arrays;

// https://www.geeksforgeeks.org/count-number-of-primes-in-an-array/
// https://leetcode.com/problems/count-primes/description/
public class CountNumberOfPrimes {

  // Approach 1
  // For every number check whether it is prime or not.
  // TC O(N*sqrt(N));

  // Approach 2
  // Sieve of Eratosthenes algorithm
  // Return the number of primes strictly less than n.
  // Explanation TAP Academy

  //  Here are the main steps of the algorithm:
  //
  // Create a boolean array to represent the range of numbers from 2 to the given limit.
  // **Initialize all elements of the array to true, as initially, all numbers are considered prime.
  // **Starting with the first prime number (2), mark off all of its multiples as non-prime by
  // setting
  // their corresponding array elements to false.
  // Find the next number in the array that is still marked as prime and repeat step 3.
  // Continue the process until you reach the square root of the given limit, as no non-prime
  // numbers beyond this point need to be considered.
  // TC - O(Nlog(n))
  public static int countPrimesV1(int n) {
    if (n <= 2) return 0; // checking for 0 and 1 ;

    int count = 0;
    // taking n+1 size array for simplicity , Oth index element is ignored
    boolean[] isPrime = new boolean[n + 1];
    // initially we will consider all the elements as prime  numbers
    Arrays.fill(isPrime, true);

    // loop is from 2 to n because all the prime will lie between them
    for (int i = 2; i <= n; i++) {
      // checking the element if it is marked as true, marked all of its multiple as false as non
      // prime
      if (isPrime[i]) {
        // marked all the multiples of the ith number as non-prime
        for (int j = i * 2; j <= n; j = j + i) {
          isPrime[j] = false;
        }
      }
    }

    // after this loop all the values which are true are prime
    for (int i = 2; i <= n; i++) {
      if (isPrime[i]) {
        count++;
      }
    }
    return count;
  }

  // Approach 2
  // find the first unmarked multiple of the  ith  number ,
  // why to mark numbers which somebody already marked
  // for ex - 2 already marked the 6 as non-prime then why 3 need to marked it again as non-prime
  // so on observation we can say that first unmarked multiple of ith number is i*i.
  // TC - o(N*log(log(N)))
  public static int countPrimesV2(int n) {
    if (n <= 2) return 0; // checking for 0 and 1 ;

    int count = 0;
    // taking n+1 size array for simplicity , Oth index element is ignored
    boolean[] isPrime = new boolean[n + 1];
    // initially we will consider all the elements as prime  numbers
    Arrays.fill(isPrime, true);

    // loop is from 2 to n because all the prime will lie between them
    for (int i = 2; i <= n; i++) {
      // checking the element if it is marked as true, marked all of its multiple as false as non
      // prime
      if (isPrime[i]) {
        // now we are starting from first unmarked multiple
        for (int j = i * i; j <= n; j = j + i) {
          isPrime[j] = false;
        }
      }
    }

    // after this loop all the values which are true are prime
    for (int i = 2; i <= n; i++) {
      if (isPrime[i]) {
        count++;
      }
    }
    return count;
  }

  // Approach 3
  // Optimization at outer loop
  // outer loop i is travelling from 2 to n - not good
  // if we observe carefully , we can restrict the outer loop boundary upto sqrt(n) for travelling
  // because there is no need going beyond this.
  // TC - O(sqrt(N)*log(log(N)))
  public static int countPrimesV3(int n) {
    if (n <= 2) return 0; // checking for 0 and 1 ;

    int count = 0;
    // taking n+1 size array for simplicity , Oth index element is ignored
    boolean[] isPrime = new boolean[n + 1];
    // initially we will consider all the elements as prime  numbers
    Arrays.fill(isPrime, true);

    // loop is from 2 to n because all the prime will lie between them
    for (int i = 2; i * i <= n; i++) {
      // checking the element if it is marked as true, marked all of its multiple as false as non
      // prime
      if (isPrime[i]) {
        // now we are starting from first unmarked multiple
        for (int j = i * i; j <= n; j = j + i) {
          isPrime[j] = false;
        }
      }
    }

    // after this loop all the values which are true are prime
    for (int i = 2; i <= n; i++) {
      if (isPrime[i]) {
        count++;
      }
    }
    return count;
  }
}
