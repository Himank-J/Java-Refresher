package Functional_Interface;

public class Employee {
    private String name;
    private double salary;

    Employee (String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return this.name;
    }

    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nEmployee name is ").append(this.name);
        sb.append("\\Employee Salary is ").append(this.salary);
        return sb.toString();
    }
}
