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

    // Constructor injection for repositories
    public AttendanceService(AttendanceRepository attendanceRepo, EmployeeRepository employeeRepo) {
        this.attendanceRepo = attendanceRepo;
        this.employeeRepo = employeeRepo;
    }

    // Method to mark attendance for an employee
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

    // Method to get today's attendance records
    public List<Attendance> getTodayAttendance() {
        return attendanceRepo.findByDate(LocalDate.now());
    }

    // Method to get all attendance records
    public List<Attendance> getAllAttendance() {
        return attendanceRepo.findAll();
    }

    // Method to update attendance
    public Attendance updateAttendance(Long id, AttendanceRequestDTO dto) {
        Attendance attendance = attendanceRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendance record not found"));

        attendance.setTimeIn(dto.getTimeIn());
        attendance.setTimeOut(dto.getTimeOut());

        return attendanceRepo.save(attendance);
 
    }

    // Method to delete attendance record
    public void deleteAttendance(Long id) {
        if (!attendanceRepo.existsById(id)) {
            throw new RuntimeException("Attendance record not found with ID: " + id);
        }
        attendanceRepo.deleteById(id);
    }

}    
