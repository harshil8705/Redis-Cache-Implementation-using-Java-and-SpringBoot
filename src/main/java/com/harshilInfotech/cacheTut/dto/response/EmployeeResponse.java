package com.harshilInfotech.cacheTut.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse implements Serializable {

    private Long employeeId;
    private String name;
    private Integer age;
    private Double experience;
    private Double salary;
    private DepartmentResponse department;
    private Instant createdAt;
    private Instant updatedAt;

}
