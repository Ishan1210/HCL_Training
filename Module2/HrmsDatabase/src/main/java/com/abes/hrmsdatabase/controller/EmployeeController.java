package com.abes.hrmsdatabase.controller;

import com.abes.hrmsdatabase.model.Employee;
import com.abes.hrmsdatabase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
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
        return employeeService.createnewEmployee(emp);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("emp_email");
        String password = credentials.get("emp_password");

        if (email == null || password == null || email.isBlank() || password.isBlank()) {
            return ResponseEntity.badRequest().body(Map.of("message", "Email and password are required"));
        }

        Employee employee = employeeService.loginEmployee(email.trim(), password);
        if (employee == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "Invalid email or password"));
        }

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("emp_id", employee.getEmp_id());
        result.put("emp_name", employee.getEmp_name());
        result.put("designation", employee.getDesignation());
        result.put("stack", employee.getStack());
        result.put("emp_email", employee.getEmp_email());
        return ResponseEntity.ok(result);
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
