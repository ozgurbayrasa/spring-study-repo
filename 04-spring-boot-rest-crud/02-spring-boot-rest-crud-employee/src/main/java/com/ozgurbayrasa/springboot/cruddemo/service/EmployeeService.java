package com.ozgurbayrasa.springboot.cruddemo.service;

import com.ozgurbayrasa.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int theID);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
