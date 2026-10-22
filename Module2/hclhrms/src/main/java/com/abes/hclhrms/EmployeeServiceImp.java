package com.abes.hclhrms;

import com.abes.hclhrms.entity.Employee;
import com.abes.hclhrms.repository.EmpRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp {
    @Autowired
    private EmpRepoImp emprepo;

    public String addEmp(){
        Employee emp1= new Employee(200,"Rahul","FSD","Java","Rahul@gmail.com");
        return emprepo.addemp(emp1);
    }
    public List<Employee> getEmp(){
        return emprepo.getEmp();
    }



}
