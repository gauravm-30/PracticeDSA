package org.practice.arrays;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> hs = new HashSet<Integer>();
    for (int integer : nums) {
      if (hs.contains(integer)) return true;
      else hs.add(integer);
    }

    return false;
  }
}
