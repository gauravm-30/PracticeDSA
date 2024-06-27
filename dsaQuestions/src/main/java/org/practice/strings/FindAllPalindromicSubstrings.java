package org.practice.strings;

public class FindAllPalindromicSubstrings {
  public static void main(String[] args) {
    String s1 = "abccbc";
    printAllPalindromicSubstring(s1);
  }

  private static void printAllPalindromicSubstring(String s1) {
    for (int i = 0; i < s1.length(); i++) {
      for (int j = i + 1; j <= s1.length(); j++) {
        String s2 = s1.substring(i, j);
        if (isPalindrome(s2)) {
          System.out.println(s2);
        }
      }
    }
  }

  private static boolean isPalindrome(String s1) {
    int i = 0, j = s1.length() - 1;
    while (i < j) {
      if (s1.charAt(i) != s1.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }
}
