package Task;
import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.time.LocalDate;

import java.util.*;
import java.util.stream.*;


public class EmployeeAnalytics {

    record Employee(int id, String name, String dept, BigDecimal salary,

                    LocalDate hireDate, Set<String> skills) {}



    static Employee e(int id, String n, String d, int sal, String date, String... skills) {

        return new Employee(id, n, d, BigDecimal.valueOf(sal),

                LocalDate.parse(date), Set.of(skills));

    }



    public static void main(String[] args) {

        List<Employee> emps = List.of(

                e(1, "Asha",   "Engineering",  90000, "2019-03-01", "Java", "SQL"),

                e(2, "Ravi",   "Engineering", 120000, "2016-07-15", "Java", "Spring", "AWS"),

                e(3, "Meera",  "HR",           60000, "2020-01-10", "Recruiting"),

                e(4, "John",   "Sales",        70000, "2018-11-20", "Negotiation", "CRM"),

                e(5, "Priya",  "Engineering", 105000, "2021-05-05", "Java", "React"),

                e(6, "Karan",  "Sales",        65000, "2022-02-14", "CRM"),

                e(7, "Sara",   "HR",           62000, "2017-09-09", "Recruiting", "Payroll"),

                e(8, "Vikram", "Finance",      80000, "2015-04-30", "Excel", "SQL"));

        // Solve Q1 to Q12 below
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("Solution of Q1");
        List<Employee> ls = emps.stream()
                .filter(e -> e.dept().equals("Engineering"))
                .sorted((e1, e2) -> e2.salary().compareTo(e1.salary()))
                .toList();
        ls.forEach(e -> System.out.print(e.name() + " "));
        System.out.println("");

        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("Solution of Q2");
        List<Employee> top3Earners = emps.stream()
                .sorted((e1, e2) -> e2.salary().compareTo(e1.salary()))
                .limit(3)
                .toList();
        top3Earners.forEach(e-> System.out.print(e.name()+" "));
        System.out.println("");

        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("Solution of Q3");
        List<String> result = emps.stream()
                .filter(e -> e.hireDate().isBefore(LocalDate.parse("2018-01-01")))
                .sorted(Comparator.comparing(Employee::hireDate))
                .map(e -> e.name() + " (" + e.hireDate().getYear() + ")")
                .toList();

        System.out.println(result);
        System.out.println("");

        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("Solution of Q3");
        String names = emps.stream()
                .map(Employee::name)
                .collect(Collectors.joining(", "));

        System.out.println(names);

    }

}
