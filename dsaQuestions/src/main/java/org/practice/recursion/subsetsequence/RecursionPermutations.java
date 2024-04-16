package org.practice.recursion.subsetsequence;

import java.util.ArrayList;
import java.util.List;

public class RecursionPermutations {

  public static void runPermutation() {
    String s1 = "abc";
    permutationsRecursively("", s1);
  }

  private static void permutationsRecursively(String processed, String unprocessed) {
    if (unprocessed.isEmpty()) {
      System.out.println(processed);
      return;
    }

    char ch = unprocessed.charAt(0);
    for (int i = 0; i < processed.length() + 1; i++) {
      String f = processed.substring(0, i);
      String s = processed.substring(i, processed.length());
      permutationsRecursively(f + ch + s, unprocessed.substring(1));
    }
  }

  private static ArrayList<String> permutationsRecursivelyReturn(
      String processed, String unprocessed) {
    if (unprocessed.isEmpty()) {
      ArrayList<String> currentResult = new ArrayList<>();
      currentResult.add(processed);
      return currentResult;
    }
    ArrayList<String> ans = new ArrayList<>();
    char ch = unprocessed.charAt(0);
    for (int i = 0; i < processed.length() + 1; i++) {
      String f = processed.substring(0, i);
      String s = processed.substring(i, processed.length());
      List<String> ansFromBelowCalls =
          permutationsRecursivelyReturn(f + ch + s, unprocessed.substring(1));
      ans.addAll(ansFromBelowCalls);
    }

    return ans;
  }

  private static int permutationsRecursivelyReturnCount(String processed, String unprocessed) {
    if (unprocessed.isEmpty()) {
      return 1;
    }
    int count = 0;
    char ch = unprocessed.charAt(0);
    for (int i = 0; i < processed.length() + 1; i++) {
      String f = processed.substring(0, i);
      String s = processed.substring(i, processed.length());
      int countFromBelowCalls =
          permutationsRecursivelyReturnCount(f + ch + s, unprocessed.substring(1));
      count = count + countFromBelowCalls;
    }

    return count;
  }
}
