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

    // Method to create a new employee
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

    // Method to get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    // Method to get an employee by ID
    public Employee getEmployeeById(Long id) {
        return employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
    }

    // Method to update an employee
    public Employee updateEmployee(Long id, EmployeeRequestDTO dto) {
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));

        employee.setName(dto.getName());
        employee.setRole(dto.getRole());
        employee.setDepartment(dto.getDepartment());

        return employeeRepo.save(employee);
    }

    // Method to delete an employee
    public void deleteEmployee(Long id) {
        if (!employeeRepo.existsById(id)) {
            throw new RuntimeException("Employee not found with ID: " + id);
        }
        employeeRepo.deleteById(id);
    }

}    
