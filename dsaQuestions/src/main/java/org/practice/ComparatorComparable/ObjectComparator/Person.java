package org.practice.ComparatorComparable.ObjectComparator;

public class Person {
  int id;
  String name;

  int age;

  Address address;

  public Person() {}

  public Person(int id, String name, int age, Address address) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.address = address;
  }

  @Override
  public String toString() {
    return "Person{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", age="
        + age
        + ", address="
        + address
        + '}';
  }
}
