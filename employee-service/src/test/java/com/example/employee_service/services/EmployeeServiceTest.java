package com.example.employee_service.services;

import com.example.employee_service.TestDataUtils;
import com.example.employee_service.entity.Employee;
import com.example.employee_service.repository.EmployeeRepository;
import com.example.employee_service.service.EmployeeService;
import com.example.employee_service.service.implementation.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private Employee employee;
//    private Employee employee2;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        employee = TestDataUtils.createTestEmployee1();
//        employee2 = TestDataUtils.createTestEmployee2();
    }

    @Test
    void testAddOrUpdateEmployee(){
        when(employeeRepository.save(employee)).thenReturn(employee);
        Employee savedEmployee = employeeService.addOrUpdate(employee);
        assertNotNull(savedEmployee);
        assertEquals("Hussain", savedEmployee.getFName());
        verify(employeeRepository, times(1)).save(employee);
    }

    //Failling test
//    @Test
//    void testAddOrUpdateEmployee2(){
//        when(employeeRepository.save(employee2)).thenReturn(employee2);
//        Employee savedEmployee = employeeService.addOrUpdate(employee2);
//        assertNotNull(savedEmployee);
//        assertEquals("Hussain", savedEmployee.getFName());
//        verify(employeeRepository, times(1)).save(employee2);
//    }
}
