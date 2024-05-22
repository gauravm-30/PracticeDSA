package org.practice.ObjectQuestions;

public class Department {
  int id;
  String name;

  public Department(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public static void print() {
    System.out.println("Hello");
  }

  @Override
  public String toString() {
    return "Department{" + "id=" + id + ", name='" + name + '\'' + '}';
  }
}
