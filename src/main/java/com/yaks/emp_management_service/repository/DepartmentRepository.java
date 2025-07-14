package com.yaks.emp_management_service.repository;

import com.yaks.emp_management_service.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
}
