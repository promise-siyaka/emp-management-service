package com.yaks.emp_management_service.service;

import com.yaks.emp_management_service.dtos.DepartmentDto;
import com.yaks.emp_management_service.entities.Department;
import com.yaks.emp_management_service.entities.Employee;
import com.yaks.emp_management_service.repository.DepartmentRepository;
import com.yaks.emp_management_service.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceimpl implements DepartmentService{
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public Department create(DepartmentDto departmentDto) {
        Department build = Department.builder().name(departmentDto.name()).description(departmentDto.description()).build();
        return departmentRepository.save(build);
    }

    @Override
    public Department update(Long id, DepartmentDto departmentDto) {
        Department byId = departmentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        if(departmentDto.name()!=null)
            byId.setName(departmentDto.name());
        if(departmentDto.description()!=null)
            byId.setDescription(departmentDto.description());
        return departmentRepository.save(byId);
    }

    @Override
    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department findById(Long id) {
        return departmentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findByEmployeeId(Long employeeId) {
        Employee byId = employeeRepository.findById(employeeId).orElseThrow(EntityNotFoundException::new);
        return departmentRepository.findById(byId.getEmployeeId()).orElse(null);
    }
}
