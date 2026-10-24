package com.abes.hclhrms.controller;

import com.abes.hclhrms.EmployeeServiceImp;
import com.abes.hclhrms.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeServiceImp employeeServiceImp;
    @GetMapping("/")
    public String welcome(){
        return "<h2 style='color:red'> Welcome to HRMS Application</h2>" + "";
    }
    @GetMapping("/addemp")
    public String addemp(){
        return employeeServiceImp.addEmp();
    }
    @GetMapping("/getemp")
    public List<Employee> getemp(){
        return employeeServiceImp.getEmp();
    }
    @GetMapping("/getempbyid")
    public Employee getempByid(){
        return employeeServiceImp.getEmpById();
    }
    @GetMapping("/addbulk")
    public String addEmpBulk(){
        return employeeServiceImp.addBulkEmp();
    }
    @DeleteMapping("/deleteById")
    public String deleteById(){
        return employeeServiceImp.deleteById();
    }
    @PutMapping("/updateById")
    public String updateById() {
        return employeeServiceImp.updateById();
    }
}
