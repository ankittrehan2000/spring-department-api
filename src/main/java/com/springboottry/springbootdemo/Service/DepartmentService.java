package com.springboottry.springbootdemo.Service;

import com.springboottry.springbootdemo.Entity.Department;
import com.springboottry.springbootdemo.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getDepartments();

    Department getDepartment(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartment(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);

    Department fetchDepartmentByName(String name);
}
