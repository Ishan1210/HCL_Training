
package com.abes.hrmsdatabase.service;

import com.abes.hrmsdatabase.model.Attendance;
import com.abes.hrmsdatabase.repository.AttendanceRepository;
import com.abes.hrmsdatabase.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public String markAttendance(Attendance attendance) {

        if (attendance == null ||
                attendance.getEmployee() == null ||
                attendance.getAttendancedate() == null) {

            return "Employee and attendance date are required";
        }

        long empId = attendance.getEmployee().getEmp_id();

        if (!employeeRepository.existsById(empId)) {
            return "Employee not found";
        }

        if (attendanceRepository.existsByEmployeeAndAttendancedate(
                attendance.getEmployee(),
                attendance.getAttendancedate())) {
            return "Attendance already exists";
        }

        attendanceRepository.save(attendance);

        return "Attendance marked successfully";
    }
}
