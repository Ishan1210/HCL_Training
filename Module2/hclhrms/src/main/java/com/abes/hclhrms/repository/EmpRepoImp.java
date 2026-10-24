package com.abes.hclhrms.repository;

import com.abes.hclhrms.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmpRepoImp implements EmployeeRepo{
    List<Employee> emplist=new ArrayList<>();

    @Override
    public String addemp(Employee emp) {
        emplist.add(emp);
        return "Employee Added Successfully";
    }

    @Override
    public List<Employee> getEmp() {
        return emplist;
    }

    @Override
    public Employee getEmpById(long emp_id) {
        return emplist.stream().filter(e -> e.getEmp_id()==emp_id).findFirst().orElse(null);
    }
    @Override
    public String addEmpbulk() {
        List <Employee> employeesList=List.of(new Employee(890,"Ram","Test Engineer","java","abc@gmail.com"),new Employee(891,"Amit","Test Engineer","java","amit@gmail.com"));
        emplist.addAll(employeesList);
        return "All employees added";
    }

    @Override
    public String deleteById(long emp_id) {
        boolean status = false;
        if (getEmpById(emp_id) != null){
            status = emplist.removeIf(e->e.getEmp_id()==emp_id);
        }
        if (status){
            return "Employee Deleted Successfully";
        }
        return "Employee is not Registered with id" + emp_id;
    }

    @Override
    public String updateById(long emp_id, Employee updatedEmp) {
        if (getEmpById(emp_id) != null) {
            emplist.removeIf(e -> e.getEmp_id() == emp_id);
            emplist.add(updatedEmp);
            return "Employee Updated Successfully";
        }
        return "Employee is not Registered with id " + emp_id;
    }
}
