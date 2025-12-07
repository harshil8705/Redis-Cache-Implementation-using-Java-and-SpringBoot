package com.harshilInfotech.cacheTut.service;

import com.harshilInfotech.cacheTut.dto.request.EmployeeRequest;
import com.harshilInfotech.cacheTut.dto.response.EmployeeResponse;
import com.harshilInfotech.cacheTut.dto.response.EmployeeResponse2;
import com.harshilInfotech.cacheTut.entity.Department;
import com.harshilInfotech.cacheTut.entity.Employee;
import com.harshilInfotech.cacheTut.exception.CustomExceptionHandler;
import com.harshilInfotech.cacheTut.repository.DepartmentRepository;
import com.harshilInfotech.cacheTut.repository.EmployeeRepository;
import com.harshilInfotech.cacheTut.util.EmployeeBuilder;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeBuilder employeeBuilder;

    @Override
    @Transactional
    public EmployeeResponse addNewEmployeeByDepartmentId(Long departmentId, EmployeeRequest request) {

        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new CustomExceptionHandler("No Department found by departmentId: " + departmentId));

        Employee employee = Employee.builder()
                .age(request.getAge())
                .name(request.getName())
                .salary(request.getSalary())
                .experience(request.getExperience())
                .department(department)
                .build();

        department.getEmployees().add(employee);
        department.setNumberOfEmployees(department.getEmployees().size());

//        departmentRepository.save(department);
        employee = employeeRepository.save(employee);

        return employeeBuilder.buildEmployeeResponse(employee);

    }

    @Override
    public List<EmployeeResponse2> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();
        if (employees.isEmpty()) {
            throw new CustomExceptionHandler("No Employees found");
        }

        return employees.stream().map(e -> employeeBuilder.buildEmployeeResponse2(e)).toList();

    }

    @Override
    @Transactional
    public EmployeeResponse2 updateEmployeeById(Long employeeId, EmployeeRequest request) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new CustomExceptionHandler("No Employee found by employeeId: " + employeeId));

        employee.setAge(request.getAge());
        employee.setName(request.getName());
        employee.setSalary(request.getSalary());
        employee.setExperience(request.getExperience());

        employee = employeeRepository.save(employee);

        return employeeBuilder.buildEmployeeResponse2(employee);

    }

    @Override
    public String deleteEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new CustomExceptionHandler("No Employee found by employeeId: " + employeeId));

        Department employeesDepartment = employee.getDepartment();
        employeesDepartment.getEmployees().remove(employee);
        employeesDepartment.setNumberOfEmployees(employeesDepartment.getEmployees().size());

        employeeRepository.delete(employee);

        return "Employee by employeeId: " + employeeId + " deleted Successfully.";

    }

    @Override
    @Transactional
    public EmployeeResponse changeEmployeeDepartment(Long employeeId, Long departmentId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new CustomExceptionHandler("No Employee found by employeeId: " + employeeId));

        Department destinationDepartment = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new CustomExceptionHandler("No Department found by departmentId: " + departmentId));

        if (employee.getDepartment().getDepartmentId().equals(departmentId))
            throw new CustomExceptionHandler("Employee is already associated with the Department whose departmentId is: " + departmentId);

        Department sourceDepartment = employee.getDepartment();
        sourceDepartment.getEmployees().remove(employee);
        sourceDepartment.setNumberOfEmployees(sourceDepartment.getEmployees().size());
        departmentRepository.save(sourceDepartment);

        destinationDepartment.getEmployees().add(employee);
        employee.setDepartment(destinationDepartment);
        destinationDepartment.setNumberOfEmployees(destinationDepartment.getEmployees().size());

//        departmentRepository.save(destinationDepartment);
        employee = employeeRepository.save(employee);

        return employeeBuilder.buildEmployeeResponse(employee);

    }

}
