package com.example.service;

import com.example.error.DepartmentNotFoundException;
import com.example.model.Department;
import com.example.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getByDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> dept =
                departmentRepository.findById(departmentId);
        if (!dept.isPresent()){
            throw new DepartmentNotFoundException("Department not found of id " + departmentId);
        }
        return dept.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> getDepartment = departmentRepository.findById(departmentId);
        if (!getDepartment.isPresent())
            throw new DepartmentNotFoundException("Department not found of id " + departmentId);
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department departmentUpdateData) {
        Department depDB = departmentRepository.findById(departmentId).get();

        // This logic for if we are updating only one field it will update only one field rest remain same
        // Here i am checking null checking and blank checking
        if (Objects.nonNull(departmentUpdateData.getDepartmentName()) &&
                !"".equalsIgnoreCase(departmentUpdateData.getDepartmentName())){
            depDB.setDepartmentName(departmentUpdateData.getDepartmentName());
        }
        if (Objects.nonNull(departmentUpdateData.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(departmentUpdateData.getDepartmentAddress())){
            depDB.setDepartmentAddress(departmentUpdateData.getDepartmentAddress());
        }
        if (Objects.nonNull(departmentUpdateData.getDepartmentCode()) &&
                !"".equalsIgnoreCase(departmentUpdateData.getDepartmentCode())){
            depDB.setDepartmentCode(departmentUpdateData.getDepartmentCode());
        }

        return departmentRepository.save(depDB);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
