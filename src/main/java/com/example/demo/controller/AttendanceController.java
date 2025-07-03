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

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping("/mark")
    public Attendance mark(@RequestBody AttendanceRequestDTO dto) {
        return attendanceService.markAttendance(dto);
    }

    @GetMapping("/today")
    public List<Attendance> today() {
        return attendanceService.getTodayAttendance();
    }

    @GetMapping("/report/pdf")
    public void downloadPdfReport(HttpServletResponse response) throws IOException {
        List<Attendance> attendances = attendanceService.getTodayAttendance();

        ByteArrayInputStream bis = PdfReportGenerator.generateAttendanceReport(attendances);

        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        response.setHeader("Content-Disposition", "attachment; filename=attendance_report.pdf");

        org.apache.commons.io.IOUtils.copy(bis, response.getOutputStream());
        response.flushBuffer();
    }
}
