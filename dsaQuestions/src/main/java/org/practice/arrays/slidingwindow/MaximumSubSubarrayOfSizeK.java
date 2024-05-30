package org.practice.arrays.slidingwindow;

public class MaximumSubSubarrayOfSizeK {
  public static void main(String[] args) {
    int[] nums = {3, 4, 6, 1, 7, 21, -10, -2};
    int k = 3; // window size
    System.out.println(maximumSumSubarrayOfSizeKV1(nums, k));
    System.out.println(maximumSumSubarrayOfSizeKV2(nums, k));
  }

  // Src TAP Academy Sliding Window Technique
  // Approach 1
  // Brute Force
  // TC O(N*K)
  private static int maximumSumSubarrayOfSizeKV1(int[] nums, int k) {
    int maxSum = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length - k; i++) {
      int currSum = 0;
      // Getting sum of the
      for (int j = i; j < (i + 3); j++) {
        currSum = currSum + nums[j];
      }

      if (currSum > maxSum) {
        maxSum = currSum;
      }
    }
    return maxSum;
  }

  // Approach 2
  // Can we solve it linear time
  // Use sliding window technique
  // TC O(N)
  // How we know that there is chance of optimization here
  // Since we were doing the repetitive task like adding the same number in different window
  public static int maximumSumSubarrayOfSizeKV2(int[] nums, int k) {
    int maxSum = Integer.MIN_VALUE;
    int windowSum = 0;

    // Initially find the windowSum
    for (int i = 0; i < k; i++) {
      windowSum = windowSum + nums[i];
    }

    // Now initially window sum has been received
    // we will start sliding the window
    for (int i = k; i < nums.length; i++) {
      // get the sum of current window
      // Subtracting the removed element from window and add the added element
      windowSum = windowSum - nums[i - k] + nums[i];
      if (windowSum > maxSum) {
        maxSum = windowSum;
      }
    }

    return maxSum;
  }

  // Using 2 Pointers
  public static int maximumSumSubarrayOfSizeKV3(int[] nums, int k) {
    int maxSum = Integer.MIN_VALUE;
    int windowSum = 0;

    // Taking two pointers
    int i = 0;
    int j = 0;

    while (j < nums.length) {
      windowSum += nums[j];
      // reached the window size
      if (j - i + 1 == k) {
        if (windowSum > maxSum) {
          maxSum = windowSum;
        }
        windowSum -= nums[i];
        i++;
      }
      j++;
    }

    return maxSum;
  }

  private static int maximumSumSubarrayOfSizeV4(int[] nums, int k) {
    int i = 0, j = 0;
    int windowSum = 0;
    int maxSum = Integer.MIN_VALUE;
    while (j < nums.length) {
      windowSum += nums[j];
      if (j - i + 1 < k) {
        j++;
      } else if (j - i + 1 == k) {
        maxSum = Math.max(maxSum, windowSum);
        windowSum = windowSum - nums[i];
        j++;
        i++;
      }
    }
    return maxSum;
  }
}
