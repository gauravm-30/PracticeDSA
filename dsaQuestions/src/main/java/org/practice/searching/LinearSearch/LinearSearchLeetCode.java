package org.practice.searching.LinearSearch;

public class LinearSearchLeetCode {
  public static void runLinearSearch() {
    int[] arr = getArray();
    System.out.println(
        "Total counts of numbers with even number of digits "
            + getNumberWithEvenNumOfDigitsCount(arr));

    System.out.println(
        "Number of digits of a number using log method " + getNumberOfDigitsUsingLog(5));
  }

  // return total numbers with even number of digits
  public static int getNumberWithEvenNumOfDigitsCount(int[] arr) {
    if (arr == null || arr.length == 0) {
      // ideally exception  should be thrown here
      return 0;
    }
    int count = 0;
    for (int num : arr) {
      if (hasEvenNumberOfDigits(num)) {
        count++;
      }
    }
    return count;
  }

  // return the richest customer wealth
  public static int maximumWealth(int[][] accounts) {
    if (accounts == null || accounts.length == 0) {
      // ideally exception  should be thrown here
      return Integer.MIN_VALUE;
    }
    int maxWealth = Integer.MIN_VALUE;
    // here money of a customer in a single bank account=accounts[customer][bankAcc]
    // number of customer=accounts.length
    // number of accounts a customer has = accounts[customer].length

    for (int customer = 0; customer < accounts.length; customer++) {
      int currentCustomerWealth = 0;
      if (accounts[customer].length != 0) {
        for (int bankAcc = 0; bankAcc < accounts[customer].length; bankAcc++) {
          currentCustomerWealth += accounts[customer][bankAcc];
        }
      }
      if (maxWealth < currentCustomerWealth) {
        maxWealth = currentCustomerWealth;
      }
    }
    return maxWealth;
  }

  private static boolean hasEvenNumberOfDigits(int num) {
    int numOfDigits = getNumberOfDigits(num);
    // we can do like this
    //    if (numOfDigits % 2 == 0) {
    //      return true;
    //    }
    //    return false;
    // OR
    //    return (numOfDigits % 2 == 0) ? true : false;
    return (numOfDigits % 2 == 0); // we can make it more optimized using bit & operator
  }

  // Get number of digits of a positive number i.e. >0
  // Approach 1
  private static int getNumberOfDigits(int num) {
    // If number is zero then number of digit will be 1.
    if (num == 0) {
      return 1;
    }
    // if the number is negative, make it positive first
    if (num < 0) {
      num = num * (-1);
    }

    int numOfDigits = 0;
    while (num > 0) {
      numOfDigits++;
      num = num / 10;
    }
    return numOfDigits;
  }

  // Get number of digits of a positive number i.e. >0
  // Approach 2
  private static int getNumberOfDigitsUsingLog(int num) {
    // You don't need to handle this case separately now
    // If number is zero then number of digit will be 1.
    //    if (num == 0) {
    //      return 1;
    //    }
    // if the number is negative, make it positive first
    if (num < 0) {
      num = num * (-1);
    }

    int numOfDigits = ((int) Math.log10(num)) + 1;

    // Now suppose we want to get the number of digits of a binary number. Just do
    // (int)Math.log2(num)+1

    return numOfDigits;
  }

  private static int[] getArray() {
    return new int[] {5, 11, 263, 8678, 0, 3};
  }

  private static int[][] get2DArray() {
    return new int[][] {
      {2, 5, 1},
      {8, 3, 6},
      {-4, 7, -8, 2},
      {0, 9, 7},
    };
  }
}
