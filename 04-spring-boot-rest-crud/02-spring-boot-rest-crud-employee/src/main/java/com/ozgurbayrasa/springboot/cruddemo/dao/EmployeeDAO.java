package com.ozgurbayrasa.springboot.cruddemo.dao;

import com.ozgurbayrasa.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int theID);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
