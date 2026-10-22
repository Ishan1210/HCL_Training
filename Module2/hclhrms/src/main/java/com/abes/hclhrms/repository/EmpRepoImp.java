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
    public Employee getEmpById(long empid) {
        return emplist.stream().filter(Employee e->e.getEmp_id()==empid);
    }

    @Override
    public String deleteById(long empid) {
        return "";
    }

    @Override
    public String updateById(long empid, Employee updatedEmp) {
        return "";
    }
}
