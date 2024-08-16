package com.ozgurbayrasa.springboot.cruddemo.dao;

import com.ozgurbayrasa.springboot.cruddemo.entity.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    // Define field for entity manager.
    private EntityManager entityManager;

    // Inject entityManager in constructor.
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    // Implement methods.
    @Override
    public List<Employee> findAll() {

        // Create a query
        TypedQuery<Employee> theQuery = entityManager
                .createQuery("FROM Employee ", Employee.class);

        // Execute query
        List<Employee> employees = theQuery.getResultList();

        // Get result
        return employees;
    }
}
