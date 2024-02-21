package com.mrd.employee.service.impl;

import com.mrd.employee.dto.APIResponseDto;
import com.mrd.employee.dto.DepartmentDto;
import com.mrd.employee.dto.EmployeeDto;
import com.mrd.employee.entity.Employee;
import com.mrd.employee.repository.EmployeeRepository;
import com.mrd.employee.service.APIClient;
import com.mrd.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private ModelMapper modelMapper;

    //private RestTemplate restTemplate;
//    private WebClient webClient;
    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDTO) {

        //convert employee DTO to employee
        Employee employee = modelMapper.map(employeeDTO, Employee.class);

        Employee savedEmployee = employeeRepository.save(employee);
        //convert employee  to employee DTO
        EmployeeDto savedEmployeeDTO = modelMapper.map(savedEmployee, EmployeeDto.class);
        return savedEmployeeDTO;
    }

    @Override
    public APIResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();
//call with Rest template
//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
//                DepartmentDto.class);
//
//        DepartmentDto departmentDto = responseEntity.getBody();

        //call with web client
//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();
        DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(modelMapper.map(employee, EmployeeDto.class));
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }
}
