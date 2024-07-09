package com.example.employee_service;

import com.example.employee_service.entity.Employee;

public final class TestDataUtils {
    private TestDataUtils(){}
    public static Employee createTestEmployee1(){
        return Employee.builder()
                .id(1L)
                .fName("Hussain")
                .lName("AlQurain")
                .phone("0536071929")
                .email("hussain.qurain@outlook.com")
                .salary(55555.0)
                .build();
    }
    public static Employee createTestEmployee2(){
        return Employee.builder()
                .id(2L)
                .fName("John")
                .lName("Doe")
                .phone("0555555555")
                .email("test@outlook.com")
                .salary(12345.0)
                .build();
    }
    public static Employee createTestEmployee3(){
        return Employee.builder()
                .id(3L)
                .fName("Random")
                .lName("Name")
                .phone("0551234567")
                .email("random@gmail.com")
                .salary(5555.5)
                .build();
    }
}
