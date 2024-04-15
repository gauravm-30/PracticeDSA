package org.practice.recursion;

public class RecursionBasicProblems {

  // fibonacci numbers
  // 0th  1st 2nd 3rd 4th 5th 6th
  // 0    1    1   2   3   5   8 ......so on
  // we know that 0th and 1st fibonacci number is 0 and 1  i.e. base condition .
  private static int fib(int n) {
    if (n == 0 || n == 1) {
      return n;
    }
    // firstly fib(n-1) complete its tree and get the result and then fib(n-2)
    return fib(n - 1) + fib(n - 2);
  }

  // factorial numbers
  // we know that )  0!=1 , 1!=1
  // 2! = 2*fact(1); and so on.
  private static int fact(int n) {
    if (n <= 1) {
      return 1;
    }
    return n * fact(n - 1);
  }

  // sumDig(1342)=sumDig(134)+2;
  // sumDig(134)=sumDig(13)+4; and so on
  // sumDig(n)=summDig(n/10)+n%10;
  // At last n<=0 then return 0;
  private static int sumOfDigits(int n) {
    if (n <= 0) {
      return 0;
    }
    return sumOfDigits(n / 10) + n % 10;
  }

  private static int productOfDigits(int n) {

    //    if (n <= 0) {
    //      return 1;
    //    }
    //    OR
    if (n % 10 == n) {
      return n;
    }
    return productOfDigits(n / 10) * n % 10;
  }

  // Binary Search with Recursion
  // In Binary search , identify what variables goes where
  // return type - int
  // Imp Tip: Whatever argument you pass into the function ,it will go into the next function call .
  //  Also since start and end is required for binary search. Identify  where to place them.
  // How can we pass the start and end into the future
  private static int binarySearch(int[] arr, int sIndex, int eIndex, int target) {
    // means you haven't found the element;
    // base condition
    if (sIndex > eIndex) {
      return -1;
    }
    // mid will be in body of the function
    // Why ?
    // Because it is specific to that function call only
    int mid = sIndex + (eIndex - sIndex) / 2;
    if (target == arr[mid]) {
      return mid;
    } else if (target < arr[mid]) {
      // Not found then search in left side
      // If returned from here then it will not go to the next binary search
      return binarySearch(arr, sIndex, mid - 1, target);
    }
    return binarySearch(arr, mid + 1, eIndex, target);
  }

  // Concept of n-- vs --n
  // Now this will run infinitely .
  // Why ?
  // Because of fun(n--) as it will use the value n first
  // Solution fun(--n)
  public static void func(int n) {
    if (n == 0) {
      return;
    }
    System.out.println(n);

    func(n--);
  }

  private static boolean palindrome(int n) {
    if (n == reversalV2(n)) {
      return true;
    }
    return false;
  }

  // return the reversal of the number
  // But this is cheating as above is taking the outside variable to do this .
  // taking outside the variable
  static int sum = 0;

  // Approach1
  private static void reversalV1(int n) {
    if (n == 0) {
      return;
    }
    sum = sum * 10 + n % 10;
    reversalV1(n / 10);
  }

  // Approach2
  // pass the base i.e. power of 10 with which remainder is multiplied
  private static int reversalV2(int n) {
    // sometimes you might need some additional variables in the argument
    // in that case , make another function known as helper function
    int digits = (int) Math.log10(n) + 1;
    return reverseHelper(n, digits);
  }

  private static int reverseHelper(int n, int digits) {
    if (n % 10 == n) {
      return n;
    }
    //    OR
    if (n == 0) {
      return 0;
    }
    return (int) (n % 10 * Math.pow(10, digits - 1) + reverseHelper(n / 10, digits - 1));
  }

  private static int countZeroes(int n) {
    int count = 0;
    if (n == 0) {
      return 1;
    }
    return countHelper(n, count);
  }

  // special pattern , how to pass the same  value to above calls
  private static int countHelper(int n, int count) {
    // passes the same value to above calls
    if (n == 0) {
      return count;
    }
    if (n % 10 == 0) {
      return countHelper(n / 10, count + 1);
    }
    return countHelper(n / 10, count);
  }
}
