package com.ozgurbayrasa.cruddemo.dao;

import com.ozgurbayrasa.cruddemo.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository

public class AppDAOImpl implements AppDAO{

    // Define field for entity manager.
    private EntityManager entityManager;

    // Inject entity manager using constructor injection.
    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    // This will also save the instructor detail
    // since cascade type is all.
    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        // This will also retrieve instructor details
        // Since fetch type is eager.
        return entityManager.find(Instructor.class, theId);
    }

    @Transactional
    @Override
    public void deleteInstructorById(int theId) {
        // Retrieve the instructor by id.
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);

        // Delete the instructor.
        entityManager.remove(tempInstructor);
    }
}
