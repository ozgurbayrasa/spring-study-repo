package com.ozgurbayrasa.springboot.cruddemo.service;

import com.ozgurbayrasa.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

}
