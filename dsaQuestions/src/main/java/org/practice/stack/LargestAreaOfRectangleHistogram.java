package org.practice.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// https://leetcode.com/problems/largest-rectangle-in-histogram/description/
// https://youtu.be/hs-wL4xxI1A?si=rlXMl8mEUDWeHL8B
// https://youtu.be/ZrFb_GLw3ew?si=9HGxHhDwZhwbmG9n

public class LargestAreaOfRectangleHistogram {
  public static void main(String[] args) {
    int[] height = {6, 2, 5, 4, 1, 5, 6};
    int[] previousSmaller = previousSmallerIndex(height);
    int[] nextSmaller = nextSmallerIndex(height);
    System.out.println(Arrays.toString(Arrays.stream(previousSmaller).toArray()));
    System.out.println(Arrays.toString(Arrays.stream(nextSmaller).toArray()));
    int max = 0;
    for (int i = 0; i < height.length; i++) {
      int cur = height[i] * (nextSmaller[i] - previousSmaller[i] - 1);
      max = Math.max(max, cur);
    }
    System.out.println("max = " + max);
  }

  private static int[] nextSmallerIndex(int[] height) {
    // array will store the indexes of smaller element for each element
    int n = height.length;
    int[] nextSmaller = new int[height.length];
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        nextSmaller[i] = n;
      } else {
        nextSmaller[i] = stack.peek();
      }
      stack.push(i);
    }

    return nextSmaller;
  }

  // Find previous smaller by using stack
  // TC- O(N)
  // SC-O(N)
  private static int[] previousSmallerIndex(int[] height) {
    // array will store the indexes of smaller element for each element
    int[] previousSmaller = new int[height.length];
    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i < previousSmaller.length; i++) {
      while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
        stack.pop();
      }

      if (stack.isEmpty()) {
        previousSmaller[i] = -1;
      } else {
        previousSmaller[i] = stack.peek();
      }
      stack.push(i);
    }

    return previousSmaller;
  }
}
