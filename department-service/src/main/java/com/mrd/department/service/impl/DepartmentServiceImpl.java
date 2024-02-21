package com.mrd.department.service.impl;

import com.mrd.department.dto.DepartmentDto;
import com.mrd.department.entity.Department;
import com.mrd.department.repository.DepartmentRepository;
import com.mrd.department.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    private ModelMapper modelMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDTO) {
        //convert department dto to department jpa entity
        Department department = modelMapper.map(departmentDTO, Department.class);

        Department savedDepartment = departmentRepository.save(department);

        //convert department entity to department dto
        DepartmentDto savedDepartmentDto = modelMapper.map(savedDepartment, DepartmentDto.class);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department = departmentRepository.findByDepartmentCode(code);
        DepartmentDto departmentDTO = modelMapper.map(department, DepartmentDto.class);

        return departmentDTO;
    }
}
