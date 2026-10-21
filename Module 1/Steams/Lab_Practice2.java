package Steams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lab_Practice2 {
    private static class Employee {
        private final String name;
        private final String department;
        private final double salary;

        private Employee(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Amit", "Engineering", 75000),
                new Employee("Neha", "Human Resources", 60000),
                new Employee("Ravi", "Engineering", 82000),
                new Employee("Priya", "Finance", 70000),
                new Employee("Sara", "Human Resources", 65000)
        );

        Map<String, Double> totalSalaryByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        employee -> employee.department,
                        Collectors.summingDouble(employee -> employee.salary)
                ));

        totalSalaryByDepartment.forEach(
                (department, totalSalary) ->
                        System.out.println(department + ": " + totalSalary)
        );
    }
}
