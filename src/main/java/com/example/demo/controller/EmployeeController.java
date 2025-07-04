package com.example.demo.controller;

import com.example.demo.dto.EmployeeRequestDTO;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid; 

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Endpoint to create a new employee
    @PostMapping()
    public Employee createEmployee(@Valid @RequestBody EmployeeRequestDTO dto) {
        return employeeService.createEmployee(dto);
    }

    // Endpoint to get all employees
    @GetMapping()
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Endpoints to update an employee by ID
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeRequestDTO dto) {
        return employeeService.updateEmployee(id, dto);
    }

    // Endpoints to delete an employee by ID
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    // Endpoint to get an employee by ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }
}
