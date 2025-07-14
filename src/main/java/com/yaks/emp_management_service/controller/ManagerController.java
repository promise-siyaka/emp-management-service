package com.yaks.emp_management_service.controller;

import com.yaks.emp_management_service.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/manager")
@RequiredArgsConstructor
public class ManagerController {
    private final EmployeeService employeeService;

    @GetMapping("/employees")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<?> getAllEmployees() {
        return ResponseEntity.ok(employeeService.findByDepartmentId());
    }

}
