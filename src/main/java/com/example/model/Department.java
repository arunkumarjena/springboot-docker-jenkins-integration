package com.example.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "DEPARTMENT")
public class Department {

    @Id
    @SequenceGenerator(
            name = "department_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "department_sequence"
    )
    @Column(name = "DEPT_ID",updatable = false)
    private Long departmentId;
    @Column(
            name = "DEPT_NAME",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NotBlank(message = "Department name should not blank")
    private String departmentName;
    @Column(
            name = "DEPT_ADDRESS",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NotBlank(message = "Department name should not blank")
    private String departmentAddress;
    @Column(
            name = "DEPT_CODE",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NotBlank(message = "Department code should not blank")
    private String departmentCode;

}
