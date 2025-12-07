package com.harshilInfotech.cacheTut.repository;

import com.harshilInfotech.cacheTut.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
