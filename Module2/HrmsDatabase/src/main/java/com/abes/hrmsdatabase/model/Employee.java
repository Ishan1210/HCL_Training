
package com.abes.hrmsdatabase.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Employee {

    @Id
    private long emp_id;

    private String emp_name;
    private String designation;
    private String stack;
    private String emp_email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String emp_password;

    public Employee() {

    }

    public Employee(long emp_id, String emp_name, String designation,
                    String stack, String emp_email, String emp_password) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.designation = designation;
        this.stack = stack;
        this.emp_email = emp_email;
        this.emp_password = emp_password;
    }

    public long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(long emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public String getEmp_email() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email = emp_email;
    }

    public String getEmp_password() {
        return emp_password;
    }

    public void setEmp_password(String emp_password) {
        this.emp_password = emp_password;
    }
}
