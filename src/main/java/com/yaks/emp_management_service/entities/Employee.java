package com.yaks.emp_management_service.entities;

import jakarta.persistence.*;
import lombok.*;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String status;
    private Long departmentId;

    @Enumerated(EnumType.STRING)
    private Role role;
}
