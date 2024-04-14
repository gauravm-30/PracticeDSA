package org.practice.strings;

import java.util.ArrayList;
import java.util.Arrays;

public class StringsDataType {

  /*
   * 1.String is a referenced class not a primitive data type
   * 2.Every string that is created is an object of type String.
   * Ex- String name= "Gaurav Maurya";
   * Here String is datatype, name is ref variable  and  "Gaurav Maurya" is an object stored in heap.
   * String s1="Gaurav";
   * String s2="Gaurav";
   * both s1 and s2 is pointing to same object "Gaurav".
   * String Pool : Special memory inside the heap to store string .
   * It is there so that it won't create the object again and again.
   * What if s1 change value of the object.Is the reference var s2 value also change ?
   * No, It will not change because String are immutable(immutability).
   * If you change the value of reference variable then new object will be created.
   * For optimization POV , we have string pool.
   * For security reasons, string are immutable.
   *
   * */

  public static void runString() {
    String a = "Gaurav";
    System.out.println(a);
    // here new object is created "Maurya" and then it get assigned to a. Now ,then what will happen
    // to object "Gaurav"?.
    // Since "Gaurav" is not referenced by any of the referenced variable .It will be removed by
    // GC(garbage collector)
    a = "Maurya";
    System.out.println(a);

    runComparison();
    prettyPrinting();
    charsPrinting();
  }

  public static void runComparison() {
    String a = "Kunal";
    String b = "Kunal";

    // == equals to operator to compare string .
    // It compares the values and the reference var(whether both pointing to the same object of not)
    System.out.println(a == b); // true

    String c = new String("Maurya");
    String d = new String("Maurya");

    // Here we create both new objects ,since values are same but they are different objects
    System.out.println(c == d); // false

    // When you need to check only the values ,use .equals method
    System.out.println(c.equals(d));

    // printing the object
    // internally it calls the String.valueOf() which calls the
    // toString() method of that type
    // default implementation:
    //      public String toString() {
    //          return getClass().getName() + "@" + Integer.toHexString(hashCode());
    //      }
    // Thats why we need to override the to String method

    System.out.println(new int[] {1, 2, 3, 4});
    // Overriden toString method
    System.out.println(Arrays.toString(new int[] {1, 2, 3, 4}));

    // Note:  primitive are stored in stack memory.
  }

  public static void prettyPrinting() {
    float f1 = 123.0954f;
    System.out.printf("Formatted string is %.2f", f1);
    System.out.println();
    // % are called java placeholders placeholders
  }

  public static void charsPrinting() {
    System.out.println('a' + 'b');
    System.out.println("a" + "b");
    System.out.println('a' + 6);
    System.out.println((char) ('a' + 6));
    System.out.println((char) (95 + 9)); // prints if it is valid character
    // Here 1 is wrapped into Integer and then toString method is called over it
    System.out.println("a" + 1);

    // Here new ArrayList<>() toString method is called over it
    System.out.println("Gaurav" + new ArrayList<>());
    System.out.println("Gaurav" + new Integer(56));

    // Imp:
    // + can be used with primitive as well as strings
    // it can be used with other complex object as well but only condition is that at least one of
    // them is string
    // System.out.println(new ArrayList<>()+new Integer(56));

    System.out.println(" " + new ArrayList<>() + new Integer(56));
  }
}
