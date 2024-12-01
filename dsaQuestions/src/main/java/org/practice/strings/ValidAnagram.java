package org.practice.strings;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram implements Serializable {

  public static void main(String[] args) {
    String s1 = "tea";
    String s2 = "ate";
    System.out.println(isValidAnagramV2(s1, s2));
    System.out.println(isValidAnagramV3(s1, s2));
  }

  // Approach 1
  // TC O(NlogN)
  //SC O(2N) == O(N)
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
  // SC : O(255) == O(1)

  //This solution is faster with the time complexity of O(n).
  // However, it needs extra space for the counting array.
  // At 256 integers, for ASCII that’s not too bad.
  //However, if we need to increase CHARACTER_RANGE to support multiple-byte character sets such as UTF-8,
  // this would become very memory hungry.
  // Therefore, it’s only really practical when the number of possible characters is in a small range.
  private static boolean isValidAnagramV2(String s1, String s2) {

    // check the length of the characters
    if (s1.length() != s2.length()) {
      return false;
    }
    // Total Ascii characters are from 0 to 255
    // Consists all the characters  special characters as well as english letters also
    int[] characterArray = new int[256];
    Arrays.fill(characterArray, 0);

    //Important, we cna do it in only one iteration because length of both the is same .
//    for(int i = 0; i < s1.length(); i++) {
//      characterArray[s1.charAt(i)]++;
//      characterArray[s2.charAt(i)]--;
//    }

    for (char character : s1.toCharArray()) {
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
  //TC O(3N) == O(N)
  //SC O(N)
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
