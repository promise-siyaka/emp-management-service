package com.yaks.emp_management_service.repository;

import com.yaks.emp_management_service.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllByDepartmentId(Long id);
    Optional<Employee> findByUserId(Long userId);
}
