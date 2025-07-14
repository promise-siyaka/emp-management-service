package com.yaks.emp_management_service.controller;


import com.yaks.emp_management_service.dtos.EmployeeDto;
import com.yaks.emp_management_service.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/employees")
@RequiredArgsConstructor
public class AdminEmployeeController {
    private final EmployeeService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody EmployeeDto emp) {
        return ResponseEntity.ok(service.create(emp));
    }

    @GetMapping
    public ResponseEntity<List<?>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping("/department/{id}")
    public ResponseEntity<?> getByDeptIdAdmin(@PathVariable Long id) {
        return ResponseEntity.ok(service.findByDepartmentIdAdmin(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody EmployeeDto emp) {
        return ResponseEntity.ok(service.update(id, emp));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return  ResponseEntity.ok("Deleted Employee successfully");
    }
}
