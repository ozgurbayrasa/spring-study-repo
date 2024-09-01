package com.ozgurbayrasa.cruddemo.entity;

import jakarta.persistence.*;

import javax.xml.stream.events.Comment;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="course")
public class Course {

    // Define fields and annotate them.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    // Define join column for reviews (one course can have many reviews)
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Review> reviews;

    // Define join table for students (many-to-many)
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "course_student",
    joinColumns =  @JoinColumn(name = "course_id"),
    inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;

    // Define constructors.

    public Course(){

    }

    public Course(String title) {
        this.title = title;
    }


    // Define getters/setters.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    // Define toString().

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + "}";
    }

    // Convenience method for adding review.
    public void addReview(Review tempReview){
        if(reviews == null){
            reviews = new ArrayList<>();
        }

        reviews.add(tempReview);
    }

    // Convenience method for adding student.
    public void addStudent(Student tempStudent){
        if(students == null){
            students = new ArrayList<>();
        }

        students.add(tempStudent);
    }
}
