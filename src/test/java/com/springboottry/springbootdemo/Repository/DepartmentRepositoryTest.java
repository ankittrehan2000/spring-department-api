package com.springboottry.springbootdemo.Repository;

import com.springboottry.springbootdemo.Entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().id(1L).code("CCI12").name("CCI").address("Philly").build();
        testEntityManager.persist(department);
    }

    @Test
    public void find_by_id_should_return_correct_response() {
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getName(), "CCI");
    }
}