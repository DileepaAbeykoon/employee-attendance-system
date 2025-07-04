package com.example.demo.dto;

import lombok.*;
import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceRequestDTO {

    @NotNull(message = "Employee ID cannot be null")
    @Positive(message = "Employee ID must be a positive number")
    private Long employeeId;

    @NotNull(message = "Time In cannot be null")
    private LocalTime timeIn;

    @NotNull(message = "Time Out cannot be null")
    private LocalTime timeOut;
}
