package org.practice.strings;

public class FindAllSubstring {
  public static void main(String[] args) {
    String s1 = "Gaurav";

    String substring = s1.substring(0, 1); // inclusive - exclusive
    String substring1 = s1.substring(0, 0); // o/p = ""
    String substring2 = s1.substring(1, 1); //   o/p = ""
    printAllSubstringV1(s1);
    new String();
  }

  private static void printAllSubstringV1(String s1) {
    for (int i = 0; i < s1.length(); i++) {
      for (int j = i + 1; j <= s1.length(); j++) {
        System.out.println(s1.substring(i, j));
      }
    }
  }
}
