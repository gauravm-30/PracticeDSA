package org.practice.ComparatorComparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Points to remember about Comparator
// We can define as many as comparator for the given  object
// Works on **collection** of objects(can be of any type)
// when we add the integers in list then it automatically autoboxed into the Integer object
// sorting the collection always required the comparator (it is like compare object to compare the
// object)

// Most of the object already have comparable interface implemented,which support natural ordering
// or the order which we defined

// Every object have only one comparable but can have many comparator
public class SortStrings {

  public static void main(String[] args) {
    runSortString();
  }

  public static void runSortString() {
    // defining the strings
    List<String> strings = new ArrayList<>(10);
    strings.add("Gaurav");
    strings.add("Ashish");
    strings.add("Sandeep");

    // create a comparator for string
    Comparator<String> stringDescComparator =
        new Comparator<>() {
          public int compare(String o1, String o2) {
            return -(o1.compareTo(o2));
          }
        };

    // create a comparator for string using lambda
    Comparator<String> stringComparatorUsingLambda = (s1, s2) -> s1.compareTo(s2);

    // create comparator for string insensitive data
    Comparator<String> stringInsensitiveComparator =
        (s1, s2) -> {
          s1 = s1.toLowerCase();
          s2 = s2.toLowerCase();
          return s1.compareTo(s2);
        };
    // sort them into ascending order
    sortStrings(strings, stringInsensitiveComparator);

    // sort them into descending order
    sortStrings(strings, stringDescComparator);

    strings.forEach(System.out::println);
  }

  private static void sortStrings(List<String> strings, Comparator<String> stringComparator) {
    strings.sort(String::compareToIgnoreCase);
    strings.sort(stringComparator);
  }

  // We can also use this below one for sorting
  private static void compareString(List<String> strings) {
    Collections.sort(strings);
  }
}
