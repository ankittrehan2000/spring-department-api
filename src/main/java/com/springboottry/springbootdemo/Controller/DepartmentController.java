package com.springboottry.springbootdemo.Controller;

import com.springboottry.springbootdemo.Entity.Department;
import com.springboottry.springbootdemo.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    // property based dependency injection
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/department")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    // implement a path variable
    @GetMapping("/department/{id}")
    public Department getDepartment(@PathVariable("id") Long departmentId) {
        return departmentService.getDepartment(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartment(departmentId);
        return "Department Deleted Successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String name) {
        return departmentService.fetchDepartmentByName(name);
    }
}
