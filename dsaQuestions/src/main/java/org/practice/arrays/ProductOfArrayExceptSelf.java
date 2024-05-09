package org.practice.arrays;

// https://leetcode.com/problems/product-of-array-except-self/description/

public class ProductOfArrayExceptSelf {

  public static void runProductExceptSelf() {
    int[] nums = {1, 2, 3, 4};

    //    int[] products = productOfArrExceptSelf(nums);
    int[] products = productOfArr(nums);
    for (int product : products) {
      System.out.println("product = " + product);
    }
  }

  // approach 1
  // Time Limit Exceeded for large array length
  // Not optimized solution
  // TC - O(N2)
  public static int[] productOfArrExceptSelf(int[] nums) {
    if (nums.length == 1) {
      return nums;
    }
    // create an array of size n
    int[] productArr = new int[nums.length]; // result array is not considered in SC
    // Handle first value
    productArr[0] = getMultiply(nums, 1, nums.length - 1);
    // Handle last value
    productArr[nums.length - 1] = getMultiply(nums, 0, nums.length - 2);

    if (nums.length >= 3) {
      // Handle in between elements
      for (int i = 1; i < nums.length - 1; i++) {
        int prod1 = getMultiply(nums, 0, i - 1);
        int prod2 = getMultiply(nums, i + 1, nums.length - 1);
        productArr[i] = prod1 * prod2;
      }
    }
    return productArr;
  }

  private static int getMultiply(int[] nums, int i, int j) {
    int product = 1;
    for (int k = i; k <= j; k++) {
      product = product * nums[k];
    }
    return product;
  }

  // Approach 2
  // Using the Division
  // First find the product of all the elements
  // For each element just divide by that element
  // Edge cases when one zero is present. {1,0, 6,7}
  // when two zeroes are present.{2,4,6,0,0}
  // TC O(N) but needed to multiply all the values int limit may exceed.

  // Approach 3
  // Using Left array and right Array concept
  // SC O(N) TC O(N)
  public static int[] productOfArr(int[] nums) {
    // edge cases
    if (nums.length == 0 || nums.length == 1) {
      return nums;
    }

    int[] productArr = new int[nums.length];
    int[] leftProduct = new int[nums.length];
    int[] rightProduct = new int[nums.length];

    // find the left product of the given elements in nums
    leftProduct[0] = 1;
    for (int i = 1; i < leftProduct.length; i++) {
      leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
    }
    // find the right product of the given elements in nums
    rightProduct[nums.length - 1] = 1;
    for (int i = nums.length - 2; i >= 0; i--) {
      rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
    }

    // getting the final result
    for (int i = 0; i < productArr.length; i++) {
      productArr[i] = leftProduct[i] * rightProduct[i];
    }
    return productArr;
  }

  // Approach 4
  // In above one we used separate left and right array .
  // Do not use it .
  // use the product arr for the same.
  // first insert the left product into this
  // and then we can use the same array and multiply the right product to the product arr
  // TC O(N) SC O(1)

  private static int[] productOfArrV2(int[] nums) {
    int[] productArr = new int[nums.length];

    // first insert the left product into the resultArr
    productArr[0] = 1;
    for (int i = 1; i < productArr.length; i++) {
      productArr[i] = productArr[i - 1] * nums[i - 1];
    }

    // now use the rightProduct variable and multiply by the left product and save it again to the
    // result arr
    int rightProduct = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      productArr[i] = productArr[i] * rightProduct;
      // right product for the next iterations
      rightProduct = rightProduct * nums[i];
    }

    return productArr;
  }
}
