package org.practice.strings;

public class StringInterviewQuestion {

  public static void stringsIntern() {

    // String s4 = new String("Gaurav").intern();: In this case, we create a new String object using
    // new, but then immediately call the intern() method on it. The intern() method checks if the
    // string value is already in the string pool. If it is, it returns the reference to the
    // existing string in the pool. Otherwise, it adds the string to the pool and returns that
    // reference. Since "Gaurav" is already in the pool (from the first line), s4 refers to the same
    // string object as s2. No additional object is created.

    // Total 2 objects
    String s1 = "Gaurav";
    String s2 = "Gaurav";
    String s3 = new String("Gaurav");
    // Below line will not create any object because of intern
    String s4 = new String("Gaurav").intern();

    String s5 = "Baeldung";
    String s6 = new String("Baeldung");
    String s7 = new String("Baeldung").intern();
    String s8 = "Gaurav";
    String s9 = new String("Gaurav");
    System.out.println(s8 == s9);
    if (s1 == s3) {
      System.out.println("true");
    }

    // Important to understand this line
    // This will help to understand that it is not every object created ,their hashcode is diferent
    // doesn't work on s1.hashcode();
    System.out.println(
        System.identityHashCode(s1)
            + "\n"
            + System.identityHashCode(s2)
            + "\n"
            + System.identityHashCode(s3)
            + "\n"
            + System.identityHashCode(s4)
            + "\n");

    System.out.println(
        s1.hashCode() + "\n" + s2.hashCode() + "\n" + s3.hashCode() + "\n" + s4.hashCode() + "\n");
  }
}
