package Functional_Interface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeMain {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Emp1", 1000);
        Employee emp2 = new Employee("Emp2", 2000);
        Employee emp3 = new Employee("Emp3", 500);

        ArrayList<Employee> empList = new ArrayList<>(List.of(emp1, emp2, emp3));
        Comparator<Employee> salaryCompare = (e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary());
        Collections.sort(empList, salaryCompare);
        System.out.println(empList.toString());
    }
}
