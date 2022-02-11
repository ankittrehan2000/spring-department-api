package com.springboottry.springbootdemo.Service;

import com.springboottry.springbootdemo.Entity.Department;
import com.springboottry.springbootdemo.Repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().name("CCI").address("Philly").code("CCI123").build();
        Mockito.when(departmentRepository.findByName("CCI")).thenReturn(department);
    }

    @Test
    @DisplayName("Get data for valid department name")
    public void should_return_valid_department_when_correct_name_is_passed_in() {
        String department = "CCI";
        Department found = departmentService.fetchDepartmentByName(department);
        assertEquals(department, found.getName());
    }
}