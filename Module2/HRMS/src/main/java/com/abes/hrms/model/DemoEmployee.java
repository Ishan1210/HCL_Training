package com.abes.hrms.model;

import com.abes.hrms.repository.EmpRepo;
import com.abes.hrms.repository.EmpRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoEmployee {
    @Autowired
    private EmpRepoImp emprepo;

    public int add(){
        return emprepo.add(20,30);
    }

    public double squareRoot(){
        return emprepo.squareroot(200);
    }

    public int gtn(){
        return emprepo.gtn(20,30);
    }
}
