package org.practice.arrays.union;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnionOfTwoArrays {
  public static void main(String[] args) {
    int[] arr1 = {1, 2, 3, 4, 5};
    int[] arr2 = {3, 5, 6, 7, 8};

    Set<Integer> union = new HashSet<>();

    // Add all elements from arr1 to the set
    for (int num : arr1) {
      union.add(num);
    }

    // Add all elements from arr2 to the set (duplicates will be ignored)
    for (int num : arr2) {
      union.add(num);
    }

    System.out.println("Union of the two arrays: " + union); // Output: [1, 2, 3, 4, 5, 6, 7, 8]

    // Convert the Set back to an array if needed (order not guaranteed)
    Integer[] unionArray = union.toArray(new Integer[0]);
    System.out.println("Union as an array: " + Arrays.toString(unionArray));
  }
}