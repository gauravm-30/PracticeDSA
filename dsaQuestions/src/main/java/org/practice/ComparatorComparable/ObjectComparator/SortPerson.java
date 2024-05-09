package org.practice.ComparatorComparable.ObjectComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortPerson {

  public static void main(String[] args) {
    List<Person> personList = new ArrayList<>();
    personList.add(new Person(1, "Maurya", 21, new Address()));
    personList.add(new Person(1, "Gaurav", 21, new Address()));
    personList.add(new Person(1, "Ashish", 23, new Address()));
    personList.add(new Person(1, "Sandeep", 22, new Address()));

    sortPersonObject(personList);
  }

  // sorting need to compare object so we need the comparator for this .
  // Comparator are created outside the class , generally
  public static void sortPersonObject(List<Person> personList) {
    Comparator<Person> sortByName =
        (Person p1, Person p2) -> {
          return p1.name.compareToIgnoreCase(p2.name);
        };

    Comparator<Person> sortByAge =
        (Person p1, Person p2) -> {
          return Integer.compare(p1.age, p2.age);
        };

    Comparator<Person> sortByAgeAndName =
        (Person p1, Person p2) -> {
          if (p1.age == p2.age) {
            return p1.name.compareToIgnoreCase(p2.name);
          }
          return Integer.compare(p1.age, p2.age);
        };
    personList.sort(sortByAgeAndName);
    personList.forEach(person -> System.out.println("person.toString() = " + person.toString()));
  }
}
