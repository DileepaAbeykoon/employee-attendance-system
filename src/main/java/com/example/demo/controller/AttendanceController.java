package com.example.demo.controller;

import com.example.demo.dto.AttendanceRequestDTO;
import com.example.demo.entity.Attendance;
import com.example.demo.service.AttendanceService;
import com.example.demo.util.PdfReportGenerator;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.servlet.http.HttpServletResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.springframework.http.MediaType;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    // Endpoint to mark attendance
    @PostMapping("/mark")
    public Attendance mark(@Valid @RequestBody AttendanceRequestDTO dto) {
        return attendanceService.markAttendance(dto);
    }

    // Endpoint to update attendance by ID
    @PutMapping("/{id}")
    public Attendance updateAttendance(@PathVariable Long id, @Valid @RequestBody AttendanceRequestDTO dto) {
        return attendanceService.updateAttendance(id, dto);
    }

    // Endpoint to get today's attendance
    @GetMapping("/today")
    public List<Attendance> today() {
        return attendanceService.getTodayAttendance();
    }

    // Endpoint to download today's attendance report as PDF
    @GetMapping("/report/pdf")
    public void downloadPdfReport(HttpServletResponse response) throws IOException {
        List<Attendance> attendances = attendanceService.getTodayAttendance();
        ByteArrayInputStream bis = PdfReportGenerator.generateAttendanceReport(attendances);
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        response.setHeader("Content-Disposition", "attachment; filename=attendance_report.pdf");
        org.apache.commons.io.IOUtils.copy(bis, response.getOutputStream());
        response.flushBuffer();
    }

    // Endpoint to get all attendance records
    @GetMapping("/all")
    public List<Attendance> getAllAttendance() {
        return attendanceService.getAllAttendance();        
    }

    // Endpoint to download all attendance records as PDF
    @GetMapping("/all/report/pdf")
    public void downloadAllPdfReport(HttpServletResponse response) throws IOException {
        List<Attendance> attendances = attendanceService.getAllAttendance();
        ByteArrayInputStream bis = PdfReportGenerator.generateAttendanceReport(attendances);
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        response.setHeader("Content-Disposition", "attachment; filename=attendance_report.pdf");
        org.apache.commons.io.IOUtils.copy(bis, response.getOutputStream());
        response.flushBuffer();
    }

    // Endpoint to delete attendance by ID
    @DeleteMapping("/{id}")
    public void deleteAttendance(@PathVariable Long id) {
        attendanceService.deleteAttendance(id);
    }
}

