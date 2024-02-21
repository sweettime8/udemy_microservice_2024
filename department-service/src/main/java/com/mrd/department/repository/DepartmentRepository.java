package com.mrd.department.repository;

import com.mrd.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentCode(String code);
}
