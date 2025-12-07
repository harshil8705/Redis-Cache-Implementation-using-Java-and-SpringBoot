package com.harshilInfotech.cacheTut.util;

import com.harshilInfotech.cacheTut.dto.response.EmployeeResponse;
import com.harshilInfotech.cacheTut.dto.response.EmployeeResponse2;
import com.harshilInfotech.cacheTut.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeBuilder {

    private final DepartmentBuilder departmentBuilder;

    public EmployeeResponse buildEmployeeResponse(Employee employee) {

        return EmployeeResponse.builder()
                .employeeId(employee.getEmployeeId())
                .age(employee.getAge())
                .salary(employee.getSalary())
                .department(departmentBuilder.buildDepartmentResponse(employee.getDepartment()))
                .experience(employee.getExperience())
                .name(employee.getName())
                .createdAt(employee.getCreatedAt())
                .updatedAt(employee.getUpdatedAt())
                .build();

    }

    public EmployeeResponse2 buildEmployeeResponse2(Employee employee) {

        return EmployeeResponse2.builder()
                .employeeId(employee.getEmployeeId())
                .age(employee.getAge())
                .salary(employee.getSalary())
                .experience(employee.getExperience())
                .name(employee.getName())
                .department(employee.getDepartment().getName())
                .createdAt(employee.getCreatedAt())
                .updatedAt(employee.getUpdatedAt())
                .build();

    }

}
