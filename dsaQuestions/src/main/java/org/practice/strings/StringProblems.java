package org.practice.strings;

public class StringProblems {
  public static void runStringProblems() {
    String s1 = "";
    String s2 = "abcba";
    String s3 = "abccba";
    String s4 = "abcdba";
    System.out.println(isPalindrome(s1));
    System.out.println(isPalindrome(s2));
    System.out.println(isPalindrome(s3));
    System.out.println(isPalindrome(s4));
    reverseStringV1();
  }

  public static void reverseStringV1() {
    String s2 = "GeeksForGeeks";
    StringBuilder reverseString = new StringBuilder();
    for (int i = s2.length() - 1; i >= 0; i--) {
      char ch = s2.charAt(i);
      reverseString = reverseString.append(ch);
      //      reverseString = reverseString.append(String.valueOf(ch));
    }
    System.out.println("reverseString = " + reverseString);
  }

  public static void reverseStringV2() {
    String s2 = "GeeksForGeeks";

    // First get stream of characters and transform each character into string
    String reverseString =
        s2.chars().mapToObj(ele -> String.valueOf((char) ele)).reduce("", (ch1, ch2) -> ch2 + ch1);
  }

  public static void reverseStringV3() {
    String s2 = "GeeksForGeeks";
    String reverseString = new StringBuilder(s2).reverse().toString();
  }

  private static boolean isPalindrome(String s1) {
    // Two doubts to interviewer while working on it
    // whether we need to consider the lowerCase and Uppercase as same
    // null should be palindrome or not
    // length 0 should be palindrome or not .

    if (s1 == null) {
      return false;
    }
    // it will create a new string object and copy all values from s1 after
    // converting it from s1.
    // An empty string is also a palindrome
    return isPalindrome(s1.toLowerCase(), 0, s1.length() - 1);
  }

  private static boolean isPalindrome(String s1, int sIndex, int eIndex) {
    while (sIndex < eIndex) {
      if (s1.charAt(sIndex) != s1.charAt(eIndex)) {
        return false;
      }
      sIndex++;
      eIndex--;
    }
    return true;
  }
}
