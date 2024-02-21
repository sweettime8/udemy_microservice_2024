package com.mrd.employee.service;

import com.mrd.employee.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {
    //Build get department code REST API
    @GetMapping("api/departments/{department-code}")
    DepartmentDto getDepartmentByCode(@PathVariable("department-code") String departmentCode);
}
