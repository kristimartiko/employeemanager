package com.getarrays.employeemanager.service;

import com.getarrays.employeemanager.dto.EmployeeDto;
import com.getarrays.employeemanager.exceptions.UserNotFoundException;
import com.getarrays.employeemanager.model.Employee;
import com.getarrays.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        employee.setJobTitle(employeeDto.getJobTitle());
        employee.setPhone(employeeDto.getPhone());
        employee.setImageUrl(employeeDto.getImageUrl());
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(EmployeeDto employeeDto, Long id) {
        Employee employee = employeeRepo.findEmployeeById(id).orElse(null);
        employee.setName(employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        employee.setJobTitle(employeeDto.getJobTitle());
        employee.setPhone(employeeDto.getPhone());
        employee.setImageUrl(employeeDto.getImageUrl());
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteEmployeeById(id);
    }

    public Employee findEmployeeById(Long id) {
       return employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User by id" + id + " was not found"));
    }
}
