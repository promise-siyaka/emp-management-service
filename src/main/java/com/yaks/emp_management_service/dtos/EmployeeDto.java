package com.yaks.emp_management_service.dtos;

import com.yaks.emp_management_service.entities.Employee;
import com.yaks.emp_management_service.entities.Role;

import java.time.LocalDateTime;

public record EmployeeDto(
        Long employeeId,
        Long userId,
        String firstName,
        String lastName,
        String email,
        String status,
        Long departmentId,
        Role role
) {

    // Compact constructor for validation and normalization
    public EmployeeDto {
        // Normalize names (capitalize first letter)
        if (firstName != null) {
            firstName = firstName.trim();
        }
        if (lastName != null) {
            lastName = lastName.trim();
        }
        if (email != null) {
            email = email.trim().toLowerCase();
        }
        if (status != null) {
            status = status.trim().toUpperCase();
        }
    }

    // Factory method for creating from entity
    public static EmployeeDto fromEntity(Employee employee) {
        return new EmployeeDto(
                employee.getEmployeeId(),
                employee.getUserId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getStatus(),
                employee.getDepartmentId(),
                employee.getRole()
        );
    }
    // Factory method for creating from entity
    public static Employee toEntity(EmployeeDto employee) {
        return Employee.builder()
                .firstName(employee.firstName())
                .lastName(employee.lastName())
                .employeeId(employee.employeeId())
                .role(employee.role())
                .email(employee.email())
                .userId(employee.userId())
                .status(employee.status())
                .departmentId(employee.departmentId())
                .build();
    }

}
