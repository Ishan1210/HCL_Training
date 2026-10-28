package com.abes.hrmsdatabase.repository;

import com.abes.hrmsdatabase.model.Attendance;
import com.abes.hrmsdatabase.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    boolean existsByEmployeeAndAttendancedate(Employee employee, LocalDate attendancedate);

    @Query("SELECT a FROM attendance a WHERE a.employee.emp_id = :empId ORDER BY a.attendancedate DESC")
    List<Attendance> findAttendanceForEmployee(@Param("empId") long empId);
}
