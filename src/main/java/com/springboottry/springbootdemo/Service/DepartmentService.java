package com.springboottry.springbootdemo.Service;

import com.springboottry.springbootdemo.Entity.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getDepartments();

    Department getDepartment(Long departmentId);
}
