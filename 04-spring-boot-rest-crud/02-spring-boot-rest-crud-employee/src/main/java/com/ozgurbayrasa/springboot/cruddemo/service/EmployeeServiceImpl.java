package com.ozgurbayrasa.springboot.cruddemo.service;

import com.ozgurbayrasa.springboot.cruddemo.dao.EmployeeDAO;
import com.ozgurbayrasa.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // set field for employeeDAO.
    private EmployeeDAO employeeDAO;

    @Autowired
    // inject employee dao in constructor.
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
