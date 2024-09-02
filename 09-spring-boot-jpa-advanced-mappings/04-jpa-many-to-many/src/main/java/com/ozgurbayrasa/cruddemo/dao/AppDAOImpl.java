package com.ozgurbayrasa.cruddemo.dao;

import com.ozgurbayrasa.cruddemo.entity.Course;
import com.ozgurbayrasa.cruddemo.entity.Instructor;
import com.ozgurbayrasa.cruddemo.entity.InstructorDetail;
import com.ozgurbayrasa.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class, theId);
    }

    @Transactional
    @Override
    public void deleteInstructorById(int theId) {
        // Retrieve the instructor by id.
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);

        // Break association of all courses for instructor.
        // Remove foreign key 'instructor' from courses first, so instructor can be deleted.
        for(Course instructorCourse:tempInstructor.getCourses()){
            instructorCourse.setInstructor(null);
        }

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

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {

        // Create query
        TypedQuery<Course> typedQuery = entityManager.createQuery(
                "from Course where instructor.id = :data", Course.class);

        typedQuery.setParameter("data", theId);

        return typedQuery.getResultList();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {

        // Create query
        // This query is similar to EAGER loading, even if fetch type is lazy.
        TypedQuery<Instructor> typedQuery = entityManager.createQuery(
                "select i from Instructor i " +
                        "JOIN FETCH i.courses " +
                        "JOIN FETCH i.instructorDetail " +
                        "where i.id = :data", Instructor.class);

        typedQuery.setParameter("data", theId);

        return typedQuery.getSingleResult();
    }

    @Transactional
    @Override
    public void updateInstructor(Instructor tempInstructor) {
        entityManager.merge(tempInstructor);
    }

    @Transactional
    @Override
    public void updateCourse(Course tempCourse) {
        entityManager.merge(tempCourse);
    }

    @Transactional
    @Override
    public void deleteCourseById(int theId) {
        // Retrieve the course
        Course tempCourse = entityManager.find(Course.class, theId);

        // Delete the course
        entityManager.remove(tempCourse);
    }

    @Transactional
    @Override
    public void saveCourse(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int theId) {
        TypedQuery<Course> query = entityManager
                .createQuery("SELECT c FROM Course c " +
                        "JOIN FETCH c.reviews " +
                        "WHERE c.id = :data", Course.class);

        query.setParameter("data", theId);

        return query.getSingleResult();
    }

    @Override
    public Course findCourseAndStudentsByCourseId(int theId) {
        // Create query
        TypedQuery<Course> query = entityManager
                .createQuery("SELECT c FROM Course c " +
                        "JOIN FETCH c.students " +
                        "WHERE c.id = :data", Course.class);

        // Set parameter on query.
        query.setParameter("data", theId);

        // Return found course.
        return query.getSingleResult();
    }

    @Override
    public Student findStudentAndCoursesByStudentId(int theId) {
        // Create query
        TypedQuery<Student> query = entityManager
                .createQuery("SELECT s FROM Student s " +
                        "JOIN FETCH s.courses " +
                        "WHERE s.id = :data", Student.class);

        // Set parameter on query.
        query.setParameter("data", theId);

        // Return found course.
        return query.getSingleResult();
    }

    @Transactional
    @Override
    public void updateStudent(Student tempStudent) {
        entityManager.merge(tempStudent);
    }

    @Transactional
    @Override
    public void deleteStudentById(int theId) {
        // Get the Student
        Student tempStudent = entityManager.find(Student.class, theId);

        // Delete the Student
        entityManager.remove(tempStudent);
    }


}
