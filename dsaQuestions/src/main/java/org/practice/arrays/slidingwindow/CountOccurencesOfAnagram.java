package org.practice.arrays.slidingwindow;

public class CountOccurencesOfAnagram {
  public static void main(String[] args) {
    String text = "forxxorfxdofr";
    String pattern = "for";
    int occurences = countOccurencesOfAnagram(text, pattern);
    System.out.println("occurences = " + occurences);
  }

  private static int countOccurencesOfAnagram(String text, String pattern) {
    int count = 0;

    // first get the characters array of both
    char[] textChars = text.toCharArray();
    char[] patternChars = pattern.toCharArray(); // defines the sliding window size

    int k = patternChars.length; // sliding window size

    // assuming that only small letters will be there
    int[] patternCharsFrequency = new int[26];
    /*
     * OR we can take all ascii characters array
     * i.e. patternCharsFrequency=new int[128]
     * */

    // Increment count for each character of pattern;
    for (int i = 0; i < patternChars.length; i++) {
      patternCharsFrequency[patternChars[i] - 'a']++;
    }

    // Initial step of sliding window technique
    // Take two pointers
    int i = 0, j = 0;
    while (j < textChars.length) {
      patternCharsFrequency[textChars[j] - 'a']--;

      // means sliding window reached
      if (j - i + 1 == k) {
        if (allZeroes(patternCharsFrequency)) {
          count++;
        }
        // removing the element from the windows
        patternCharsFrequency[textChars[i] - 'a']++;
        // shifting the window
        i++;
      }
      j++;
    }
    return count;
  }

  private static boolean allZeroes(int[] patternCharsFrequency) {
    for (int frequency : patternCharsFrequency) {
      if (frequency != 0) {
        return false;
      }
    }
    return true;
  }
}
