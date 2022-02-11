package com.springboottry.springbootdemo.Service;

import com.springboottry.springbootdemo.Entity.Department;
import com.springboottry.springbootdemo.Repository.DepartmentRepository;
import com.springboottry.springbootdemo.error.DepartmentNotFoundException;
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
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartment(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if (!department.isPresent()) {
            throw new DepartmentNotFoundException("Department Not Found");
        }
        return department.get();
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department savedDepartment = departmentRepository.findById(departmentId).get();
        if (Objects.nonNull(department.getName()) && !"".equalsIgnoreCase(department.getName())) {
            savedDepartment.setName(department.getName());
        }
        if (Objects.nonNull(department.getAddress()) && !"".equalsIgnoreCase(department.getAddress())) {
            savedDepartment.setName(department.getName());
        }
        if (Objects.nonNull(department.getCode()) && !"".equalsIgnoreCase(department.getCode())) {
            savedDepartment.setName(department.getName());
        }
        return departmentRepository.save(savedDepartment);
    }

    @Override
    public Department fetchDepartmentByName(String name) {
        // no default method available in JPA repository
        return departmentRepository.findByName(name);
    }
}
