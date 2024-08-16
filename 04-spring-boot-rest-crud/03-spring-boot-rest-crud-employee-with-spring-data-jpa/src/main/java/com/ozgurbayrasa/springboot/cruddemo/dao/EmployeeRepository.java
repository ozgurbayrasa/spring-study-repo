package com.ozgurbayrasa.springboot.cruddemo.dao;

import com.ozgurbayrasa.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // That's basically it. No need for implementation since Spring Data JPE already does it.

}
