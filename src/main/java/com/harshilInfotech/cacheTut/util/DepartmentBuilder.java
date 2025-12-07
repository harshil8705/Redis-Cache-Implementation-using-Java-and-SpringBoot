package com.harshilInfotech.cacheTut.util;

import com.harshilInfotech.cacheTut.dto.response.DepartmentResponse;
import com.harshilInfotech.cacheTut.entity.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentBuilder {

    public DepartmentResponse buildDepartmentResponse(Department department) {

        return DepartmentResponse.builder()
                .departmentId(department.getDepartmentId())
                .numberOfEmployees(department.getNumberOfEmployees())
                .createdAt(department.getCreatedAt())
                .name(department.getName())
                .updatedAt(department.getUpdatedAt())
                .build();

    }

}
