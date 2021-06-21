package com.example.service;

import com.example.error.DepartmentNotFoundException;
import com.example.model.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getAllDepartment();

    Department getByDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    Department updateDepartmentById(Long departmentId, Department departmentUpdateData);

    Department fetchDepartmentByName(String departmentName);
}
