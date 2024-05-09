package org.practice.arrays;

// https://leetcode.com/problems/third-maximum-number/description/
// https://www.geeksforgeeks.org/find-second-largest-element-array/

import java.util.Arrays;
import java.util.Comparator;

public class SecondLargestElement {

  // Approach 1
  // Sort the array
  // And then use loop variable to find the second largest element
  // TC O(nlogn)
  // SC O(N) or O(1)
  public static int secondLargestElement(int[] nums) {

    // Sort in descending order using streams
    int[] sorted =
        Arrays.stream(nums)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();
    // OR
    //  Arrays.sort(nums);
    // then use two pointer to make it into descending order.
    // if we write our own logic to sort the numbers in descending order then SC - O(1) may possible

    for (int i = 1; i < sorted.length; i++) {
      // because it may possible that largest number is keep on repeating
      if (sorted[i] != sorted[0]) {
        return sorted[i + 1];
      }
    }
    // if second largest element is not present then
    return sorted[0];
  }

  // Approach 2
  // Find the second largest by traversing array twice.
  // The approach is to traverse the array twice. In the first traversal, find the maximum element.
  // In the second traversal, find the greatest element excluding the previous greatest.
  // TC O(N)
  private static int secondLargestElementV2(int[] nums) {
    int largest = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;

    for (int num : nums) {
      largest = Math.max(num, largest);
    }
    for (int num : nums) {
      if (num != largest) {
        secondLargest = Math.max(num, secondLargest);
      }
    }

    // if secondLargest remains Integer.minValue it means it all values of array is largest
    if (secondLargest != Integer.MIN_VALUE) {
      return secondLargest;
    }
    return largest;
  }

  // Approach 3
  // Find the second largest element by traversing once.
  // The idea is to keep track of the largest and second largest element while traversing the array.
  // If an element is greater than the largest element, we update the largest as well as the second
  // largest. Else if an element is smaller than largest but greater than second largest, then we
  // update the second largest only
  private static int secondLargestElementV3(int[] nums) {
    int firstLargest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > firstLargest) {
        secondLargest = firstLargest;
        firstLargest = nums[i];
      }
      if (nums[i] < firstLargest && nums[i] > secondLargest) {
        secondLargest = nums[i];
      }
    }
    if (secondLargest != Integer.MIN_VALUE) {
      return secondLargest;
    }
    return firstLargest;
  }
}
