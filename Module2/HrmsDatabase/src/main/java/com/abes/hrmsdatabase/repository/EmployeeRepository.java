package com.abes.hrmsdatabase.repository;

import com.abes.hrmsdatabase.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.emp_email = :email AND e.emp_password = :password")
    Employee findLoginEmployee(@Param("email") String email, @Param("password") String password);
}
