package com.yaks.emp_management_service.service;

import com.yaks.emp_management_service.dtos.EmployeeDto;
import com.yaks.emp_management_service.entities.Employee;
import com.yaks.emp_management_service.entities.Role;
import com.yaks.emp_management_service.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;
    private final UserService userService;

    @Override
    public Employee create(EmployeeDto employee) {
        Employee entity = EmployeeDto.toEntity(employee);
        return employeeRepository.save(entity);
    }

    @Override
    public Employee update(Long id, EmployeeDto updated) {
        Employee employee = employeeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        employee.setEmail(updated.email());
        employee.setStatus(updated.status());
        employee.setDepartmentId(updated.departmentId());
        employee.setLastName(updated.lastName());
        employee.setFirstName(updated.firstName());
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Employee findByContext() {
        Long userId = userService.getUserId();
        return employeeRepository.findByUserId(userId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findByDepartmentId() {
        Long userId = userService.getUserId();
        Employee manager = employeeRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
        if(manager.getRole().equals(Role.ROLE_MANAGER))
            return employeeRepository.findAllByDepartmentId(manager.getDepartmentId());
        throw new EntityNotFoundException("You don't have Access to view this department");
    }

    @Override
    public List<Employee> findByDepartmentIdAdmin(Long departmentId) {
        return employeeRepository.findAllByDepartmentId(departmentId);
    }
}
