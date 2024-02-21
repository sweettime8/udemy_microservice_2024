package com.mrd.employee.service;

import com.mrd.employee.dto.APIResponseDto;
import com.mrd.employee.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDTO);

    APIResponseDto getEmployeeById(Long id);

}
