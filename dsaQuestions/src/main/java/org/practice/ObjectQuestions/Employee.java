package org.practice.ObjectQuestions;

public class Employee {
  int id;
  String name;
  int d_id;

  public Employee(int id, String name, int d_id) {
    this.id = id;
    this.name = name;
    this.d_id = d_id;
  }

  @Override
  public String toString() {
    return "Employee{" + "id=" + id + ", name='" + name + '\'' + ", d_id=" + d_id + '}';
  }
}
