package com.mrd.employee.controller;

import com.mrd.employee.dto.APIResponseDto;
import com.mrd.employee.dto.EmployeeDto;
import com.mrd.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    //build Save employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDTO){
        EmployeeDto saveEmployeeDTO = employeeService.saveEmployee(employeeDTO);
        return new ResponseEntity<>(saveEmployeeDTO, HttpStatus.CREATED);
    }


    @GetMapping("{employee-id}")
    public ResponseEntity<APIResponseDto> saveEmployee(@PathVariable("employee-id") Long employeeId){
        APIResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }
}
