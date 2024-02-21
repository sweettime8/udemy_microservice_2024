package com.mrd.department.controller;

import com.mrd.department.dto.DepartmentDto;
import com.mrd.department.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;

    //Build save department REST API
    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDTO){
        DepartmentDto savedDepartmentDTO = departmentService.saveDepartment(departmentDTO);
        return new ResponseEntity<>(savedDepartmentDTO, HttpStatus.CREATED);
    }

    //Build get department code REST API
    @GetMapping("/{department-code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("department-code") String departmentCode){
        DepartmentDto departmentDTO = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentDTO, HttpStatus.OK);
    }
}
