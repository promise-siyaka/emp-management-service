package com.yaks.emp_management_service.service;

import com.yaks.emp_management_service.dtos.DepartmentDto;
import com.yaks.emp_management_service.entities.Department;

import java.util.List;

public interface DepartmentService {
    Department create(DepartmentDto departmentDto);
    Department update(Long id, DepartmentDto departmentDto);
    void delete(Long id);
    Department findById(Long id);
    List<Department> findAll();
    Department findByEmployeeId(Long id);

}
