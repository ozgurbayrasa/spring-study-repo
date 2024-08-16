package com.ozgurbayrasa.springboot.cruddemo.rest;

import com.ozgurbayrasa.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ozgurbayrasa.springboot.cruddemo.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    // Inject employee service with constructor injection.
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    // expose "/employees" endpoint to return a list of employees.
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    // expose "/employees/{studentId}" endpoint to employee by Id.
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null){
            throw new RuntimeException("Employee is not found - " + employeeId);
        }

        return theEmployee;
    }

    // Add mapping for POST /employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        // Set id to 0 to make a save instead of update.
        theEmployee.setId(0);

        Employee employeeNew = employeeService.save(theEmployee);
        return employeeNew;
    }

    // Add mapping for PUT /employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee employeeUpdated = employeeService.save(theEmployee);
        return employeeUpdated;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee tempEmployee = employeeService.findById(employeeId);

        if(tempEmployee == null){
            throw new RuntimeException("Employee is not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Employee deleted with id - " + employeeId;
    }
}
