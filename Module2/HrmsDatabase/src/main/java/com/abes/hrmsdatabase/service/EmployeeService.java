package com.abes.hrmsdatabase.service;

import com.abes.hrmsdatabase.model.Employee;
import com.abes.hrmsdatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String createnewEmployee(Employee newEmp) {
        employeeRepository.save(newEmp);
        return "Employee added successfully";
    }

    public String registerEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "Employee registered successfully";
    }

    public Employee loginEmployee(String email, String password) {
        return employeeRepository.findLoginEmployee(email, password);
    }

    public Employee getEmployeeById(long emp_id) {
        return employeeRepository.findById(emp_id).orElse(null);
    }

    public String deleteEmployeeById(long emp_id) {
        if (employeeRepository.existsById(emp_id)) {
            employeeRepository.deleteById(emp_id);
            return "Employee deleted successfully";
        }
        return "Employee not found";
    }

    public String updateEmployeeById(long emp_id) {
        Employee emp = employeeRepository.findById(emp_id).orElse(null);
        if (emp != null) {
            emp.setEmp_name("Ishan");
            emp.setDesignation("Developer");
            emp.setStack("Java FSD");
            employeeRepository.save(emp);
            return "Employee updated successfully";
        }
        return "Employee not found";
    }
}
