package com.example.demo.dto;

import lombok.*;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceRequestDTO {
    private Long employeeId;
    private LocalTime timeIn;
    private LocalTime timeOut;
}
