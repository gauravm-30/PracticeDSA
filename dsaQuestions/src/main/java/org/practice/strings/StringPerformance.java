package org.practice.strings;

public class StringPerformance {

  public static void runPerformance() {
    checkStringPerformance();
    runStringBuilderPerformance();
  }

  // Now, Every time series value is changed, it creates the new object, dereference from old one
  // and reference to new object.
  // So much of memory wastage and GC need to work to free to dereference object from memory
  // Also: transition from series="a" to "ab" involves two step process
  // 1. It will create the new object and copy the value from old one.
  // 2. Append the new value into it.
  // 3. Since string is nothing but char[] data. So copying element from one char[] array to another
  // takes O(N) time and O(1) for appending.
  // So in below it
  //  String str = "abc"; is equivalent to:
  //  char data[] = {'a', 'b', 'c'};
  //  String str = new String(data);
  private static void checkStringPerformance() {
    String series = "";
    for (int i = 0; i < 26; i++) {
      char ch = (char) ('a' + i);
      // below itself takes O(N) TC i.e. O(N) for copying element from old char[] data to
      // new char[] + O(1) for append. So overall this loop takes O(N^2) TC
      series = series + ch;
    }
    System.out.println(series);
  }

  // We can use the other datatype if we want to manipulate the string value. I.E. StringBuilder
  // class
  // It doesn't create the new object every time .
  // It just append the next upcoming element into the existing one just like in array.
  private static void runStringBuilderPerformance() {
    StringBuilder series = new StringBuilder();
    for (int i = 0; i < 26; i++) {
      char ch = (char) ('a' + i);
      // It itself takes O(1) TC i.e.  O(1) for append. So overall this loop takes O(N) TC
      series = series.append(ch);
    }
    System.out.println(series); // it will call the StringBuilder toString method
  }
}
