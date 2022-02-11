package com.springboottry.springbootdemo.Repository;

import com.springboottry.springbootdemo.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // putting the private variable name after the method tells spring which field we want to search by
    // in Spring docs can find all types of methods
    public Department findByName(String departmentName);
}
