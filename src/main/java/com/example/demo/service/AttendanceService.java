package com.example.demo.service;

import com.example.demo.repository.AttendanceRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.dto.AttendanceRequestDTO;
import com.example.demo.entity.Attendance;
import com.example.demo.entity.Employee;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceService {
    private final EmployeeRepository employeeRepo;
    private final AttendanceRepository attendanceRepo;

    public AttendanceService(AttendanceRepository attendanceRepo, EmployeeRepository employeeRepo) {
        this.attendanceRepo = attendanceRepo;
        this.employeeRepo = employeeRepo;
    }

    public Attendance markAttendance(AttendanceRequestDTO dto) {
        Employee employee = employeeRepo.findById(dto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Attendance attendance = Attendance.builder()
                .employee(employee)
                .date(LocalDate.now())
                .timeIn(dto.getTimeIn())
                .timeOut(dto.getTimeOut())
                .build();

        return attendanceRepo.save(attendance);
    }

    public List<Attendance> getTodayAttendance() {
        return attendanceRepo.findByDate(LocalDate.now());
    }
}
