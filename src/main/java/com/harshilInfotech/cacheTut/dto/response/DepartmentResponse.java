package com.harshilInfotech.cacheTut.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentResponse {

    private Long departmentId;
    private String name;
    private Integer numberOfEmployees;
    private Instant createdAt;
    private Instant updatedAt;

}
