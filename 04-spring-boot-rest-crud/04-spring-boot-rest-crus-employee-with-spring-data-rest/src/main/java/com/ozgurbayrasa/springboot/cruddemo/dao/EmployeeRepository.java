package com.ozgurbayrasa.springboot.cruddemo.dao;

import com.ozgurbayrasa.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // That's basically it. No need for implementation since Spring Data JPE already does it.
}
