package com.example.employee_service.service;

import com.example.employee_service.entity.Employee;
import jakarta.persistence.Entity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee addOrUpdate(Employee employee);
    List<Employee> findAll();
    Page<Employee> findAll(Pageable pageable);
    Optional<Employee> findOne(Long id);
    boolean exists(Long id);
    Employee partialUpdate(Long id, Employee employee);
    void delete(Long id);
}
