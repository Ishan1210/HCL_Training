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
    public int sum(){
        System.out.println("inside /add controller point");
        int result=demoemployee.add();
        System.out.println("result from model="+result);
        return result;
    }
    @GetMapping("/sqrt")
    public double getSqrt(){
        double result=demoemployee.squareRoot();
        System.out.println("result from model="+result);
        return result;
    }
    @GetMapping("/gtn")
    public int gtn(){
        int result=demoemployee.gtn();
        System.out.println("result from model="+result);
        return result;
    }
}
