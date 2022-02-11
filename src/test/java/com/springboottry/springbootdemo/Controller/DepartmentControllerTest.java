package com.springboottry.springbootdemo.Controller;

import com.springboottry.springbootdemo.Entity.Department;
import com.springboottry.springbootdemo.Service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department deparment;

    @BeforeEach
    void setUp() {
        deparment = Department.builder().address("Philly").code("CCi1").name("CCI").id(1L).build();
    }

    @Test
    void saveDepartment() {
        Department input = Department.builder().address("Philly").code("CCi1").name("CCI").id(1L).build();
        Mockito.when(departmentService.saveDepartment(input)).thenReturn(deparment);
    }

    @Test
    void getDepartment() {
    }
}