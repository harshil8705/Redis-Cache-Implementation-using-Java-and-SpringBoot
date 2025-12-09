package com.harshilInfotech.cacheTut.service;

import com.harshilInfotech.cacheTut.dto.request.EmployeeRequest;
import com.harshilInfotech.cacheTut.dto.response.EmployeeResponse;
import com.harshilInfotech.cacheTut.dto.response.EmployeeResponse2;
import jakarta.validation.Valid;

import java.util.List;

public interface EmployeeService {

    EmployeeResponse2 addNewEmployeeByDepartmentId(Long departmentId, @Valid EmployeeRequest request);

    List<EmployeeResponse2> getAllEmployees();

    EmployeeResponse2 getEmployeeById(Long employeeId);

    EmployeeResponse2 updateEmployeeById(Long employeeId, @Valid EmployeeRequest request);

    String deleteEmployeeById(Long employeeId);

    EmployeeResponse changeEmployeeDepartment(Long employeeId, Long departmentId);

}
