package com.yaks.emp_management_service.controller;

import com.yaks.emp_management_service.dtos.DepartmentDto;
import com.yaks.emp_management_service.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/department")
@RequiredArgsConstructor
public class AdminDepartmentController {
    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody DepartmentDto dept) {
        return ResponseEntity.ok(departmentService.create(dept));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(departmentService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody DepartmentDto dept) {
        return ResponseEntity.ok(departmentService.update(id, dept));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        departmentService.delete(id);
        return  ResponseEntity.ok("Department deleted");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.findById(id));
    }
}
