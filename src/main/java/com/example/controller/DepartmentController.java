package com.example.controller;

import com.example.error.DepartmentNotFoundException;
import com.example.model.Department;
import com.example.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);


    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Post mapping department controller");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> selectAllDepartment(){
        LOGGER.info("Select all get mapping department controller");
        return departmentService.getAllDepartment();
    }

    @GetMapping("/departments/{id}")
    public Department getById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        LOGGER.info("Get Mapping by id department controller");
        return departmentService.getByDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartment(@PathVariable("id")Long departmentId) throws DepartmentNotFoundException {
        LOGGER.info("Delete Mapping by Id department controller");
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully with id" + departmentId;
    }
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                         @RequestBody Department departmentUpdateData){
        LOGGER.info("Update Mapping by ID department controller");
        return departmentService.updateDepartmentById(departmentId,departmentUpdateData);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        LOGGER.info("Get Mapping by Name department controller");
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
