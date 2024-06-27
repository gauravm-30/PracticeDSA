package org.practice.strings;

/**
 * When you execute the line `String s4 = new String("Gaurav").intern();`, let's break down what
 * happens:
 *
 * <p>1. The string literal `"Gaurav"` is automatically interned when the class containing this code
 * is loaded by the JVM. 2. The `new String("Gaurav")` creates a new `String` object on the heap,
 * with its internal character array containing a copy of the interned string `"Gaurav"`. 3. The
 * `intern()` method checks whether the string `"Gaurav"` is already in the string pool. Since it is
 * (due to step 1), it returns a reference to the existing interned string. 4. The reference
 * returned by `intern()` is assigned to `s4`.
 *
 * <p>In summary, only one additional object is created explicitly on the heap (the `new
 * String("Gaurav")`), but the interned string `"Gaurav"` was already present in the string pool. So
 * the net effect is **one additional object** created by this line of code. 😊
 *
 * <p>If you have more questions or need further clarification, feel free to ask! ¹²
 *
 * <p>Source: Conversation with Copilot, 19/6/2024 (1) java - String s = new String("xyz"). How many
 * objects has been made ....
 * https://stackoverflow.com/questions/19672427/string-s-new-stringxyz-how-many-objects-has-been-made-after-this-line-of.
 * (2) Number of objects created when using String intern method in Java.
 * https://stackoverflow.com/questions/25948799/number-of-objects-created-when-using-string-intern-method-in-java.
 * (3) Java String intern() method - javatpoint. https://www.javatpoint.com/java-string-intern. (4)
 * Java - tell if a String is interned? - Stack Overflow.
 * https://stackoverflow.com/questions/4883821/java-tell-if-a-string-is-interned. (5) Interning of
 * String in Java - GeeksforGeeks. https://www.geeksforgeeks.org/interning-of-string/. (6) How to
 * Check if a String is an Integer in Java - hatchjs.com.
 * https://hatchjs.com/java-check-if-string-is-integer/. (7) What's the best way to check if a
 * String represents an integer in Java ....
 * https://stackoverflow.com/questions/237159/whats-the-best-way-to-check-if-a-string-represents-an-integer-in-java.
 * (8) What is Java String interning? - Stack Overflow.
 * https://stackoverflow.com/questions/10578984/what-is-java-string-interning. (9) String intern()
 * Method in Java With Examples - Scaler Topics. https://www.scaler.com/topics/intern-in-java/. (10)
 * Java String intern() - Programiz.
 * https://www.programiz.com/java-programming/library/string/intern. (11) String interning -
 * Wikipedia. https://en.wikipedia.org/wiki/String_interning. (12) undefined.
 * http://docs.oracle.com/javase/7/docs/api/java/lang/String.html. (13) undefined.
 * http://www.codeinstructions.com/2009/01/busting-javalangstringintern-myths.html.
 */
public class StringObjects {
  public static void main(String[] args) {
    String s3 = "Gaurav";

    String s1 = new String(s3);
    String s2 = s1.intern();
  }
}
