package com.getarrays.employeemanager.controller;

import com.getarrays.employeemanager.dto.EmployeeDto;
import com.getarrays.employeemanager.model.Employee;
import com.getarrays.employeemanager.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployee() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("/find/{id}")
    public Employee getEmployee(@PathVariable("id") Long id) {
        return employeeService.findEmployeeById(id);
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.addEmployee(employeeDto);
    }

    @PutMapping("/update/{id}")
    public void updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable("id") Long id) {
        employeeService.updateEmployee(employeeDto, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
    }

}
