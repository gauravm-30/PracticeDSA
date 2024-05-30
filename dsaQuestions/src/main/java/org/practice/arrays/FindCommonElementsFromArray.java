package org.practice.arrays;

import java.util.HashSet;
import java.util.Set;

public class FindCommonElementsFromArray {
  public static void main(String[] args) {
    printCommonElements();
  }

  // Approach 1
  // We can go iterate one array and for each element of that array we can iterate another array

  // Approach 2
  // Using Hashsets
  private static void printCommonElements() {
    int[] nums1 = {4, 7, 1, 3, 9, 4, 9, 5, 5};
    int[] nums2 = {2, 4, 5, 9};

    // it will add the unique elements from nums 1
    Set<Integer> integerSet = new HashSet<>();
    for (int num : nums1) {
      integerSet.add(num);
    }

    // now try adding elements of nums 2 , those which are not added are element common in both
    for (int num : nums2) {
      boolean added = integerSet.add(num);
      if (!added) {
        System.out.println(num + "");
      }
    }
  }
}
