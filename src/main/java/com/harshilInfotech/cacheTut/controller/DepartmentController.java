package com.harshilInfotech.cacheTut.controller;

import com.harshilInfotech.cacheTut.dto.request.DepartmentRequest;
import com.harshilInfotech.cacheTut.dto.response.DepartmentResponse;
import com.harshilInfotech.cacheTut.service.DepartmentServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentServiceImpl departmentService;

    @PostMapping
    public ResponseEntity<DepartmentResponse> addNewDepartment(@RequestBody @Valid DepartmentRequest request) {

        return new ResponseEntity<>(departmentService.addNewDepartment(request), HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<DepartmentResponse>> getAllDepartments() {

        return new ResponseEntity<>(departmentService.getAllDepartments(), HttpStatus.OK);

    }

    @PutMapping("/{departmentId}")
    public ResponseEntity<DepartmentResponse> updateDepartmentById(
            @PathVariable Long departmentId,
            @RequestBody @Valid DepartmentRequest request
    ) {

        return new ResponseEntity<>(departmentService.updateDepartmentById(departmentId, request), HttpStatus.OK);

    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable Long departmentId) {

        return new ResponseEntity<>(departmentService.deleteDepartmentById(departmentId), HttpStatus.OK);

    }

}
