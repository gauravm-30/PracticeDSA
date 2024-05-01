package org.practice.searching.LinearSearch;

public class LinearSearchString {
  public static void runLinearSearch() {
    String name = "Gaurav Maurya";
    char ch = 'y';
    System.out.println(searchCharReturnIndex(name, ch));
    System.out.println(Character.MIN_VALUE);
  }

  private static int searchCharReturnIndex(String searchString, char target) {
    if (searchString == null || searchString.length() == 0) {
      return -1;
    }

    for (int i = 0; i < searchString.length(); i++) {
      if (target == searchString.charAt(i)) {
        return i;
      }
    }
    return -1;
  }

  private static boolean searchCharReturnBoolean(String searchString, char target) {
    if (searchString == null || searchString.length() == 0) {
      return false;
    }

    for (int i = 0; i < searchString.length(); i++) {
      if (target == searchString.charAt(i)) {
        return true;
      }
    }
    return false;
  }

  /*
   *In Java, the Character class provides constants for the maximum and minimum values that a char data type can hold:

  Character.MAX_VALUE: This constant represents the maximum value that a char can store.
  *  It corresponds to the Unicode character with the hexadecimal value 0xFFFF (which is equivalent to decimal 65535).
  * However, keep in mind that this character is not printable by definition, so when you directly print Character.MAX_VALUE,
  *  you’ll see a question mark (?).
  Character.MIN_VALUE: This constant represents the minimum value that a char can hold.
  * It corresponds to the Unicode character with the hexadecimal value 0x0000 (which is equivalent to decimal 0).
  *  Unlike Character.MAX_VALUE, Character.MIN_VALUE represents the null character and is also not printable.
  To print the actual numeric values of these constants, you can cast them to int and then display them using System.out.println:

  Java

  public class Main {
      public static void main(String[] args) {
          System.out.println("Char Min Value: " + (int) Character.MIN_VALUE);
          System.out.println("Char Max Value: " + (int) Character.MAX_VALUE);
      }
  }

  Running this code will output:
  Char Min Value: 0
  Char Max Value: 65535
     * */
  private static char searchCharReturnElement(String searchString, char target) {
    if (searchString == null || searchString.length() == 0) {
      return Character.MIN_VALUE; // represents null char
    }
    for (int i = 0; i < searchString.length(); i++) {
      if (target == searchString.charAt(i)) {
        return target;
      }
    }
    return Character.MIN_VALUE; // represents null char
  }
}
