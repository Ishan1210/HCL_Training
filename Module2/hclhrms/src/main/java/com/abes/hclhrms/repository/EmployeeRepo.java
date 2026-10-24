package com.abes.hclhrms.repository;

import com.abes.hclhrms.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo {
    String addemp(Employee emp);
    List<Employee> getEmp();
    Employee getEmpById(long emp_id);

    String addEmpbulk();

    String deleteById(long emp_id);
    String updateById(long emp_id,Employee updatedEmp);


}
