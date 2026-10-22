package com.abes.hrms.controller;

import com.abes.hrms.model.DemoEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private DemoEmployee demoemployee;

    @GetMapping("/")
    public String welcome(){
        return "<h2 style='color:red'>Welcome to HRMS App</h2>";
    }
    @GetMapping("/add")
    public int sum(int a,int b){
        int result=demoemployee.add(20,50);
        return 0;
    }
}
