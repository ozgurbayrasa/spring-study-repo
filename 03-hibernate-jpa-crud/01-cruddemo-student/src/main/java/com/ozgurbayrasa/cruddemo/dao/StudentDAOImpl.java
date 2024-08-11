package com.ozgurbayrasa.cruddemo.dao;

import com.ozgurbayrasa.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

    // define field for entity manager.
    private EntityManager entityManager;

    // inject entity manager.
    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    // implement save method.
    // Transactional from spring.
    @Transactional
    @Override
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }
}
