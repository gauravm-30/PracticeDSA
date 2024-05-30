package org.practice.arrays.slidingwindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FirstNegativeNumberInEveryWindowSizeK {

  public static void main(String[] args) {
    int[] nums = {-1, -2, -3, 4, -5, 9, 0, -2};
    int k = 2;
    System.out.println(firstNegativeNumberInWindowSizeKV1(nums, k));
  }

  public static List<Integer> firstNegativeNumberInWindowSizeKV1(int[] nums, int k) {
    int i = 0;
    int j = 0;
    List<Integer> result = new ArrayList<>();
    Deque<Integer> negativeNumbers = new ArrayDeque<>();
    while (j < nums.length) {
      if (nums[j] < 0) {
        negativeNumbers.add(nums[j]);
      }

      // when the window size is reached
      if (j - i + 1 == k) {
        // Sliding window checked and filled negative numbers in queue.
        if (!negativeNumbers.isEmpty()) {
          result.add(negativeNumbers.getFirst());
        } else {
          result.add(0);
        }
        // Shifting the window
        // It is required here because it may possible that same negative element appears in more
        // than 2 windows
        if (nums[i] < 0 && !negativeNumbers.isEmpty()) {
          negativeNumbers.removeFirst();
        }
        i++;
      }
      j++;
    }
    return result;
  }
}
