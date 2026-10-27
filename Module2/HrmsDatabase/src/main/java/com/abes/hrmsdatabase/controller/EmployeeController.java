
package com.abes.hrmsdatabase.controller;

import com.abes.hrmsdatabase.model.Employee;
import com.abes.hrmsdatabase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/v1/user")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String msg() {
        return "<h2>Welcome to Springboot HRMS Database Application</h2>";
    }

    @PostMapping("/addemp")
    public String addnewEmployee(@RequestBody Employee emp) {

//        System.out.println("Employee ID: " + emp.getEmp_id());
//        System.out.println("Employee Name: " + emp.getEmp_name());
//        System.out.println("Employee Email: " + emp.getEmp_email());
//        System.out.println("Employee Password: " + emp.getEmp_password());

        return employeeService.createnewEmployee(emp);
    }

    @GetMapping("/findbyid/{emp_id}")
    public Employee getEmpById(@PathVariable long emp_id) {
        return employeeService.getEmployeeById(emp_id);
    }

    @DeleteMapping("/deletebyid/{emp_id}")
    public String deleteEmployeeById(@PathVariable long emp_id) {
        return employeeService.deleteEmployeeById(emp_id);
    }

    @PutMapping("/updatebyid/{emp_id}")
    public String updateEmployeeById(@PathVariable long emp_id) {
        return employeeService.updateEmployeeById(emp_id);
    }
}
