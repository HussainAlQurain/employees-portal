package com.example.employee_service.mapper.impl;

import com.example.employee_service.dto.EmployeeDto;
import com.example.employee_service.entity.Employee;
import com.example.employee_service.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapperImpl implements Mapper<Employee, EmployeeDto> {
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmployeeDto mapTo(Employee employee) {
        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    public Employee mapFrom(EmployeeDto employeeDto) {
        return modelMapper.map(employeeDto, Employee.class);
    }
}
