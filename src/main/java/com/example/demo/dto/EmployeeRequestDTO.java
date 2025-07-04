package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDTO {

    @NotBlank(message = "Employee name cannot be blank")
    private String name;

    @NotBlank(message = "Employee role cannot be blank")
    private String role;

    @NotBlank(message = "Employee department cannot be blank")
    private String department;
}
