package com.yaks.emp_management_service.service;

import com.yaks.emp_management_service.dtos.EmployeeDto;
import com.yaks.emp_management_service.entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee create(EmployeeDto employee);
    Employee update(Long id, EmployeeDto updated);
    void delete(Long id);
    Employee findById(Long id);
    Employee findByContext();
    List<Employee> findAll();
    List<Employee> findByDepartmentId();
    List<Employee> findByDepartmentIdAdmin(Long departmentId);
}
