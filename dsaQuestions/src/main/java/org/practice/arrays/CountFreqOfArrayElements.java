package org.practice.arrays;

import java.util.HashMap;
import java.util.Map;

// https://www.geeksforgeeks.org/counting-frequencies-of-array-elements/
// https://leetcode.com/problems/contains-duplicate/
public class CountFreqOfArrayElements {

  public static void countFrequency() {
    int[] arr = {10, 10, 20, 30, 40, 40, 40};
    countFreqV1(arr);
  }

  public static void countFreqV1(int[] arr) {
    // by default all values of array will be false
    boolean[] visited = new boolean[arr.length];

    for (int i = 0; i < arr.length; i++) {
      // skip the element if already processed
      if (visited[i]) {
        continue;
      }
      int count = 1;
      // if all elements are uniques then visited will be false always if we comment the below line
      // mark the current element as visited
      // not necessary but for understanding purpose
      visited[i] = true;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] == arr[j]) {
          visited[j] = true;
          count++;
        }
        System.out.println("Frequency of element: " + arr[i] + " is " + count);
      }
    }
  }

  public static void countFreqV2(int[] arr) {
    Map<Integer, Integer> freqMap = new HashMap<>();

    for (int j : arr) {
      if (!freqMap.containsKey(j)) {
        freqMap.put(j, 1);
      } else {
        freqMap.put(j, freqMap.get(j) + 1);
      }
    }
    for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
      System.out.printf("frequency of %d is %d", entry.getKey(), entry.getValue());
    }
  }
}
