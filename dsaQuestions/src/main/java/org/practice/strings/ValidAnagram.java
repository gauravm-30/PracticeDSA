package org.practice.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
  public static void main(String[] args) {
    String s1 = "tea";
    String s2 = "ate";
    System.out.println(isValidAnagramV2(s1, s2));
    System.out.println(isValidAnagramV3(s1, s2));
  }

  // Approach 1
  // TC O(NlogN)
  private static boolean isValidAnagramV1(String s1, String s2) {

    // check the length of the characters
    if (s1.length() != s2.length()) {
      return false;
    }

    // Get array of characters from Strings
    char[] s1_chars = s1.toCharArray();
    char[] s2_chars = s2.toCharArray();

    // sort the characters
    Arrays.sort(s1_chars);
    Arrays.sort(s2_chars);

    // Now check whether they are equal or not ?
    return Arrays.equals(s1_chars, s2_chars);
  }

  // Approach 2
  // Using extra space Since space is constant
  // TC : O(N)
  // SC : O(128) == O(1)
  private static boolean isValidAnagramV2(String s1, String s2) {

    // check the length of the characters
    if (s1.length() != s2.length()) {
      return false;
    }
    // Ascii characters are from 0 to 127
    // Consists all the characters  special characters as well as english letters also
    int[] characterArray = new int[128];
    Arrays.fill(characterArray, 0);

    for (char character : s2.toCharArray()) {
      characterArray[character]++;
    }

    for (char character : s2.toCharArray()) {
      characterArray[character]--;
    }

    for (int val : characterArray) {
      if (val != 0) {
        return false;
      }
    }
    return true;
  }

  // Approach 3 using hashmap
  private static boolean isValidAnagramV3(String s1, String s2) {

    // check the length of the characters
    if (s1.length() != s2.length()) {
      return false;
    }

    Map<Character, Integer> freqMap = new HashMap<>();

    for (char character : s1.toCharArray()) {
      if (!freqMap.containsKey(character)) {
        freqMap.put(character, 1);
      } else {
        freqMap.put(character, freqMap.get(character) + 1);
      }
    }

    for (char character : s2.toCharArray()) {
      if (freqMap.containsKey(character)) {
        freqMap.put(character, freqMap.get(character) - 1);
      }
    }

    for (Map.Entry<Character, Integer> characterIntegerEntry : freqMap.entrySet()) {
      if (characterIntegerEntry.getValue() != 0) {
        return false;
      }
    }

    return true;
  }
}
