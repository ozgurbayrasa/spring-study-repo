package com.ozgurbayrasa.cruddemo.dao;

import com.ozgurbayrasa.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;

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

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> studentQuery = entityManager.createQuery("FROM Student", Student.class);

        // return query result
        return studentQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastNameParam) {
        // create query
        TypedQuery<Student> studentQuery = entityManager
                .createQuery("FROM Student WHERE lastName =:theData", Student.class);

        // set named parameter
        studentQuery.setParameter("theData", lastNameParam);

        // return result
        return studentQuery.getResultList();
    }

    @Transactional
    @Override
    public void update(Student theStudent) {
        entityManager.merge(theStudent);

        // Set 'bayrasa' to 'tester' in last names.
        entityManager
                .createQuery("UPDATE Student s SET s.lastName = 'Tester' WHERE s.lastName = 'bayrasa'")
                .executeUpdate();
    }
}
