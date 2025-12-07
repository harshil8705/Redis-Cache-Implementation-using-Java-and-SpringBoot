package com.harshilInfotech.cacheTut.service;

import com.harshilInfotech.cacheTut.dto.request.DepartmentRequest;
import com.harshilInfotech.cacheTut.dto.response.DepartmentResponse;
import com.harshilInfotech.cacheTut.entity.Department;
import com.harshilInfotech.cacheTut.exception.CustomExceptionHandler;
import com.harshilInfotech.cacheTut.repository.DepartmentRepository;
import com.harshilInfotech.cacheTut.util.DepartmentBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentBuilder departmentBuilder;

    @Override
    public DepartmentResponse addNewDepartment(DepartmentRequest request) {

        Department department = Department.builder()
                .name(request.getName())
                .numberOfEmployees(0)
                .employees(new HashSet<>())
                .build();

        department = departmentRepository.save(department);

        return departmentBuilder.buildDepartmentResponse(department);

    }

    @Override
    public List<DepartmentResponse> getAllDepartments() {

        List<Department> departments = departmentRepository.findAll();
        if (departments.isEmpty()) {
            throw new CustomExceptionHandler("No Departments Found");
        }

        return departments.stream().map(d ->
                departmentBuilder.buildDepartmentResponse(d)).toList();

    }

    @Override
    public DepartmentResponse updateDepartmentById(Long departmentId, DepartmentRequest request) {

        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new CustomExceptionHandler("No Department found by departmentId: " + departmentId));

        department.setName(request.getName());

        department = departmentRepository.save(department);

        return departmentBuilder.buildDepartmentResponse(department);

    }

    @Override
    public String deleteDepartmentById(Long departmentId) {

        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new CustomExceptionHandler("No Department found by departmentId: " + departmentId));

        departmentRepository.delete(department);

        return "Department with departmentId: " + departmentId + " deleted Successfully.";

    }

}
