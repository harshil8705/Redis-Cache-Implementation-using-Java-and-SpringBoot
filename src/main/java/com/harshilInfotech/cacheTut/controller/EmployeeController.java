package com.harshilInfotech.cacheTut.controller;

import com.harshilInfotech.cacheTut.dto.request.EmployeeRequest;
import com.harshilInfotech.cacheTut.dto.response.EmployeeResponse;
import com.harshilInfotech.cacheTut.dto.response.EmployeeResponse2;
import com.harshilInfotech.cacheTut.service.EmployeeServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    @PostMapping("/{departmentId}")
    public ResponseEntity<EmployeeResponse> addNewEmployeeByDepartmentId(
            @PathVariable Long departmentId,
            @RequestBody @Valid EmployeeRequest request
    ) {

        return new ResponseEntity<>(employeeService.addNewEmployeeByDepartmentId(departmentId, request), HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponse2>> getAllEmployees() {

        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);

    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeResponse2> updateEmployeeById(
            @PathVariable Long employeeId,
            @RequestBody @Valid EmployeeRequest request)
    {

        return new ResponseEntity<>(employeeService.updateEmployeeById(employeeId, request), HttpStatus.OK);

    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long employeeId) {

        return new ResponseEntity<>(employeeService.deleteEmployeeById(employeeId), HttpStatus.OK);

    }

    @PutMapping("/{employeeId}/departments/{departmentId}")
    public ResponseEntity<EmployeeResponse> changeEmployeeDepartment(@PathVariable Long employeeId, @PathVariable Long departmentId) {

        return new ResponseEntity<>(employeeService.changeEmployeeDepartment(employeeId, departmentId), HttpStatus.OK);

    }

}
