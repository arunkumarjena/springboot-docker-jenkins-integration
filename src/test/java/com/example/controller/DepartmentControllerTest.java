package com.example.controller;

import com.example.error.DepartmentNotFoundException;
import com.example.model.Department;
import com.example.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = department.builder()
                .departmentName("IT")
                .departmentAddress("Delhi")
                .departmentCode("IT 01")
                .departmentId(1L)
                .build();

    }

    @Test
    void saveDepartment() throws Exception {
        Department inputData = Department.builder()
                .departmentName("IT")
                .departmentAddress("Delhi")
                .departmentCode("IT 01")
                .departmentId(1L)
                .build();
            Mockito.when(departmentService.saveDepartment(inputData))
                    .thenReturn(department);
            mockMvc.perform(post("/api/v1/departments")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\n" +
                            "\t\"departmentName\" : \"IT\",\n" +
                            "\t\"departmentAddress\" : \"Delhi\",\n" +
                            "\t\"departmentCode\" : \"IT 01\"\n" +
                            "}"))
                    .andExpect(status().isOk());
    }

    @Test
    void getById() throws Exception {
        Mockito.when(departmentService.getByDepartmentById(1L))
                .thenReturn(department);
        mockMvc.perform(get("/api/v1/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName").
                        value(department.getDepartmentName()));
    }
}