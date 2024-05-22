package org.practice.ObjectQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// We need to get the department and its associated employees
public class DemoClass {
  public static void main(String[] args) {

    Department d1 = new Department(111, "kajdh");
    // List of employees
    List<Employee> employees =
        List.of(
            new Employee(1, "Gaurav", 101),
            new Employee(2, "Amit", 102),
            new Employee(3, "Parnesh", 102),
            new Employee(4, "Puskar", 103),
            new Employee(5, "Ashish", 103),
            new Employee(6, "Puskar1", 104),
            new Employee(7, "Puskar2", 104),
            new Employee(8, "Puskar3", 105),
            new Employee(9, "Puskar4", 105),
            new Employee(10, "Puskar5", 105));

    // List of departments
    List<Department> departments =
        List.of(
            new Department(101, "Maths"),
            new Department(102, "Physics"),
            new Department(103, "History"),
            new Department(104, "Chemistry"),
            new Department(105, "Computer"));

    Map<Department, List<Employee>> departmentEmployee = new HashMap<>();
    List<Employee> employeeByDept = new ArrayList<>();
    for (Department dept : departments) {
      for (Employee employee : employees) {
        // get the list of employees by dept
        if (dept.id == employee.d_id) {
          employeeByDept.add(employee);
        }
      }
      departmentEmployee.put(dept, new ArrayList<>(employeeByDept));
      employeeByDept.clear();
    }

    departmentEmployee.forEach(
        (dept, employeeList) -> {
          System.out.println("entryKey = " + dept.toString());
          for (Employee employee : employeeList) System.out.println(employee.toString());
        });
  }
}
