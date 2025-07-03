package com.example.demo.service;

import com.example.demo.repository.EmployeeRepository;
import com.example.demo.dto.EmployeeRequestDTO;
import com.example.demo.entity.Employee;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepo;

    public EmployeeService(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee createEmployee(EmployeeRequestDTO dto) {
        // Check for duplicate employee name
        if (employeeRepo.existsByName(dto.getName())) {
            throw new IllegalArgumentException("Employee with name '" + dto.getName() + "' already exists.");
        }

        // Create and save new employee
        Employee employee = Employee.builder()
                .name(dto.getName())
                .role(dto.getRole())
                .department(dto.getDepartment())
                .build();

        return employeeRepo.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }
}
