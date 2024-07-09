package com.example.employee_service.service.implementation;

import com.example.employee_service.entity.Employee;
import com.example.employee_service.repository.EmployeeRepository;
import com.example.employee_service.service.EmployeeService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee addOrUpdate(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return StreamSupport.stream(repository
                .findAll()
                .spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Employee> findOne(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean exists(Long id) {
        return repository.existsById(id);
    }

    @Override
    public Employee partialUpdate(Long id, Employee employee) {
        employee.setId(id);
        return repository.findById(id).map(existingEmployee -> {
                    Optional.ofNullable(employee.getFName()).ifPresent(existingEmployee::setFName);
                    Optional.ofNullable(employee.getLName()).ifPresent(existingEmployee::setLName);
                    Optional.ofNullable(employee.getPhone()).ifPresent(existingEmployee::setPhone);
                    Optional.ofNullable(employee.getEmail()).ifPresent(existingEmployee::setEmail);
                    Optional.ofNullable(employee.getSalary()).ifPresent(existingEmployee::setSalary);
                    return repository.save(existingEmployee);
                }).orElseThrow(() -> new RuntimeException("Employee does not exist!"));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
