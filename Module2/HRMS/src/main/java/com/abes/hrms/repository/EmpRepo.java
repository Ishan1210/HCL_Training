package com.abes.hrms.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo {
    double squareroot(double d);
    String empData();
    int add(int a,int b);
    int gtn(int a,int b);
}
