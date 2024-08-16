package com.ozgurbayrasa.springboot.cruddemo.service;

import com.ozgurbayrasa.springboot.cruddemo.dao.EmployeeRepository;
import com.ozgurbayrasa.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // set field for employeeDAO.
    private EmployeeRepository employeeRepository;

    @Autowired
    // inject employee dao in constructor.
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theID) {
        Optional<Employee> result = employeeRepository.findById(theID);

        Employee theEmployee = null;

        if (result.isPresent()){
            theEmployee = result.get();
        }
        else{
            throw new RuntimeException("Did not find employee id - " + theID);
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
