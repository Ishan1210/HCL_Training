package com.abes.hrmsdatabase.controller;

import com.abes.hrmsdatabase.model.Attendance;
import com.abes.hrmsdatabase.service.AttendanceService;
import com.abes.hrmsdatabase.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("v1/user/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @PostMapping("/markattendance")
    public String markAttendance(@RequestBody Attendance attendance) {
        return attendanceService.markAttendance(attendance);
    }

    @GetMapping("/{emp_id}")
    public List<Attendance> getEmployeeAttendance(@PathVariable("emp_id") long empId) {
        return attendanceRepository.findAttendanceForEmployee(empId);
    }
}
