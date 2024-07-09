package com.example.employee_service.controller;

import com.example.employee_service.dto.EmployeeDto;
import com.example.employee_service.entity.Employee;
import com.example.employee_service.mapper.Mapper;
import com.example.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @Autowired
    private Mapper<Employee, EmployeeDto> mapper;


    @GetMapping
    public List<EmployeeDto> getAllEmployees(){
        List<Employee> employees = service.findAll();
        return employees.stream().map(mapper::mapTo).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id) {
        Optional<Employee> employee = service.findOne(id);
        return employee.map(value -> ResponseEntity.ok(mapper.mapTo(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee employee = mapper.mapFrom(employeeDto);
        Employee savedEmployee = service.addOrUpdate(employee);
        return mapper.mapTo(savedEmployee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        if (!service.exists(id)) {
            return ResponseEntity.notFound().build();
        }
        Employee employee = mapper.mapFrom(employeeDto);
        employee.setId(id);
        Employee updatedEmployee = service.addOrUpdate(employee);
        return ResponseEntity.ok(mapper.mapTo(updatedEmployee));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EmployeeDto> partialUpdateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        try {
            Employee updatedEmployee = service.partialUpdate(id, mapper.mapFrom(employeeDto));
            return ResponseEntity.ok(mapper.mapTo(updatedEmployee));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        if (!service.exists(id)) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/paged")
    public Page<EmployeeDto> getAllEmployees(Pageable pageable) {
        Page<Employee> employees = service.findAll(pageable);
        return employees.map(mapper::mapTo);
    }

}
