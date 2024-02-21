package com.mrd.department.service;

import com.mrd.department.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDTO);

    DepartmentDto getDepartmentByCode(String code);
}
