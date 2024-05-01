package org.practice.recursion.subsetsequence;

import java.util.ArrayList;
import java.util.List;

public class RecursionLeetCodeSubsetProblems {
  public static void runLeetcodeProblems() {
    //    phonePad("", "23");
    //    var list = phonePadV1("", "23");
    //    list.stream().forEach(System.out::println);
    diceTarget("", 4);
  }

  // LeetCode
  // https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
  // Approach subset processed and unprocessed pattern
  private static void phonePad(String processed, String unprocessed) {
    if (unprocessed.isEmpty()) {
      System.out.println(processed);
      return;
    }
    // In decimal '2' is considered as 50 and '0' is considered as 48.
    int digit = unprocessed.charAt(0) - '0'; // this will convert '2' to 2

    // for (int i = (digit - 2) * 3; i < (digit-1) * 3; i++) //as per given question

    for (int i = (digit - 2) * 3; i < (digit - 1) * 3; i++) {
      char ch = (char) ('a' + i); // getting the next character

      phonePad(processed + ch, unprocessed.substring(1));
    }
  }

  private static List<String> phonePadV1(String processed, String unprocessed) {
    if (unprocessed.isEmpty()) {
      List<String> list = new ArrayList<>();
      list.add(processed);
      return list;
    }
    // In decimal '2' is considered as 50 and '0' is considered as 48.
    int digit = unprocessed.charAt(0) - '0'; // this will convert '2' to 2

    // for (int i = (digit - 2) * 3; i < (digit-1) * 3; i++) //as per given question
    List<String> arr = new ArrayList<>();
    for (int i = (digit - 2) * 3; i < (digit - 1) * 3; i++) {
      char ch = (char) ('a' + i); // getting the next character
      List<String> listFromBelowCalls = phonePadV1(processed + ch, unprocessed.substring(1));
      arr.addAll(listFromBelowCalls);
    }
    return arr;
  }

  private static void diceTarget(String processed, int target) {
    if (target == 0) {
      System.out.println(processed);
      return;
    }
    for (int i = 1; i <= 6 && i <= target; i++) {
      diceTarget(processed + i, target - i);
    }
  }

  // for 6 face /7 face Die
  private static void diceTargetFaced(String processed, int target, int face) {
    if (target == 0) {
      System.out.println(processed);
      return;
    }
    for (int i = 1; i <= face && i <= target; i++) {
      diceTargetFaced(processed + i, target - i, face);
    }
  }

  private static List<String> diceTargetReturn(String processed, int target) {
    if (target == 0) {
      List<String> list = new ArrayList<>();
      list.add(processed);
      return list;
    }
    List<String> arr = new ArrayList<>();
    for (int i = 1; i <= 6 && i <= target; i++) {
      List<String> listFromBelowCalls = diceTargetReturn(processed + i, target - i);
      arr.addAll(listFromBelowCalls);
    }
    return arr;
  }
}
