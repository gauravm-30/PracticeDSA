package org.practice.arrays;

// Solution : https://youtu.be/IFVare4srdA?si=PUq7tJAcsYJ2SEzp  TAP_Academy

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/trapping-rain-water/description/
public class TrappingRainWater {
  public static void main(String[] args) {
    int[] heights = {4, 2, 0, 3, 2, 5};
    //    System.out.println(trappedWaterV1(heights));
    System.out.println(trappedWaterV2(heights));
  }

  // Approach 1
  // Brute Force
  // TC - O(n^2)
  // For each element find ,leftMaxHeight and rightMaxHeight
  // To trap water minimum 3 heights are required
  // Ascending block can't store water
  // Descending block can't store water
  private static int trappedWaterV1(int[] height) {
    if (height == null || height.length < 3) {
      return 0;
    }

    int trappedWater = 0;
    // Now we will find the amount of water that can be trapped over every elevation bar
    // find rightBar and leftBar
    // find water level min(leftBar and rightBar)
    // find trappedWater =waterLevel-heightOfBar
    // Add all the trapped water and return the result
    for (int i = 1; i < height.length - 1; i++) {

      // find leftBar
      int leftHighestBar = height[i];
      for (int j = 0; j < i; j++) {
        if (leftHighestBar < height[j]) {
          leftHighestBar = height[j];
        }
      }

      // find rightBar
      int rightHighestBar = height[i];
      for (int j = i + 1; j < height.length; j++) {
        if (rightHighestBar < height[j]) {
          rightHighestBar = height[j];
        }
      }

      int waterLevel = Math.min(leftHighestBar, rightHighestBar);
      int currentBarTrappedWater = (waterLevel - height[i]);
      trappedWater = trappedWater + currentBarTrappedWater;
    }

    return trappedWater;
  }

  // Approach 2
  // We can use extra two arrays to calculate the leftHighestBar and rightHighestBar for each of the
  // element and then we can find the water Level and trapped water for each  bar .
  // TC O(3N)
  // SC O(2N)
  private static int trappedWaterV2(int[] height) {
    if (height == null || height.length < 3) {
      return 0;
    }

    int trappedWater = 0;
    int[] leftHighestBars = new int[height.length];
    int[] rightHighestBars = new int[height.length];

    // Loop for calculating the left highest bars
    leftHighestBars[0] = height[0];
    for (int i = 1; i < height.length; i++) {
      leftHighestBars[i] = Math.max(leftHighestBars[i - 1], height[i]);
    }

    // Loop for calculating the left highest bars
    rightHighestBars[height.length - 1] = height[height.length - 1];
    for (int i = height.length - 2; i >= 0; i--) {
      rightHighestBars[i] = Math.max(height[i], rightHighestBars[i + 1]);
    }

    // Loop for calculating the trapped water
    for (int i = 0; i < height.length; i++) {
      int waterLevel = Math.min(leftHighestBars[i], rightHighestBars[i]);
      int currentBarTrappedWater = (waterLevel - height[i]);
      trappedWater = trappedWater + currentBarTrappedWater;
    }

    return trappedWater;
  }

  // Approach 3
  // We can use stack to store the index
  // Src:LogicHeap Rain water stack based solution
  //  https://youtu.be/lhzrp3Nbj-w?si=qR8aeD_4sbTN4f8G
  //  For each bar, do the following:
  //  Loop while the Stack is not empty and the current bar has a height greater than the top bar of
  // the stack,
  //  Store the index of the top bar in pop_height and pop it from the Stack.
  //  Find the distance between the left bar(current top) of the popped bar and the current bar.
  //  Find the minimum height between the top bar and the current bar.
  //  The maximum water that can be trapped is distance * min_height.
  //  The water trapped, including the popped bar, is (distance * min_height) – height[pop_height].
  //  Add that to the answer.
  //  Return the amount received as the total amount of water
  private static int trappingWaterV3(int[] height) {
    // Stores the indices of the bars
    Deque<Integer> stack = new ArrayDeque<>();

    int trappedWater = 0;

    // Loop through each  bar
    for (int i = 0; i < height.length; i++) {

      // Remove the bars from the stack until the condition holds
      while (!stack.isEmpty() && height[stack.peek()] < height[i]) {

        // store the height of the top
        // and pop it.
        int pop_height = height[stack.peek()];
        stack.pop();

        // If the stack does not have any
        // bars or the popped bar
        // has no left boundary
        if (stack.isEmpty()) break;

        // Get the distance between the
        // left and right boundary of
        // popped bar
        int distance = i - stack.peek() - 1;

        // Calculate the min. height
        int min_height = Math.min(height[stack.peek()], height[i]) - pop_height;

        trappedWater += distance * min_height;
      }
      // If the stack is either empty or
      // height of the current bar is less than
      // or equal to the top bar of stack
      stack.push(i);
    }
    return trappedWater;
  }

  // Two pointer algorithm

  private static int trappedWater(int[] height) {
    int trappedWater = 0;

    // initially considering this
    int leftHighestBar = height[0], rightHighestBar = height[height.length - 1];

    // taking two pointers
    int leftPointer = 0, rightPointer = height.length - 1;

    while (leftPointer <= rightPointer) {
      if (leftHighestBar <= rightHighestBar) {
        if (leftHighestBar <= height[leftPointer]) {
          leftHighestBar = height[leftPointer];
        } else {
          trappedWater = trappedWater + (leftHighestBar - height[leftPointer]);
        }
        leftPointer++;
      } else {
        if (rightHighestBar <= height[rightPointer]) {
          rightHighestBar = height[rightPointer];
        } else {
          trappedWater = trappedWater + (rightHighestBar - height[rightPointer]);
        }
        rightPointer--;
      }
    }

    return trappedWater;
  }
}
