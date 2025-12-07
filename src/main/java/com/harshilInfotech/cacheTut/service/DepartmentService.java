package com.harshilInfotech.cacheTut.service;

import com.harshilInfotech.cacheTut.dto.request.DepartmentRequest;
import com.harshilInfotech.cacheTut.dto.response.DepartmentResponse;
import jakarta.validation.Valid;

import java.util.List;

public interface DepartmentService {

    DepartmentResponse addNewDepartment(@Valid DepartmentRequest request);

    List<DepartmentResponse> getAllDepartments();

    DepartmentResponse updateDepartmentById(Long departmentId, @Valid DepartmentRequest request);

    String deleteDepartmentById(Long departmentId);

}
