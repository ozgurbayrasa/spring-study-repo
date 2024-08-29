package com.ozgurbayrasa.cruddemo.dao;

import com.ozgurbayrasa.cruddemo.entity.Instructor;
import com.ozgurbayrasa.cruddemo.entity.InstructorDetail;
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

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Transactional
    @Override
    public void deleteInstructorDetailById(int theId) {
        // Retrieve the instructor detail by id.
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);

        // Remove the associated object reference.
        // Break bidirectional link.
        // Since only instructorDetail will be deleted. (CascadeType.REMOVE -> Not included)
        tempInstructorDetail.getInstructor().setInstructorDetail(null);

        // Delete the instructor detail.
        entityManager.remove(tempInstructorDetail);
    }
}
