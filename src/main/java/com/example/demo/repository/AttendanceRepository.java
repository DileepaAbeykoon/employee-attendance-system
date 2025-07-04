package com.example.demo.repository;

import com.example.demo.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    // Find attendance records by date
    List<Attendance> findByDate(LocalDate date);
    // Find attendance records by employee ID
    Optional<Attendance> findByEmployeeIdAndDate(Long employeeId, LocalDate date);
}
