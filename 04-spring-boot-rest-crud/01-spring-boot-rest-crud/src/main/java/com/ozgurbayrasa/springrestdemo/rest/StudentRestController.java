package com.ozgurbayrasa.springrestdemo.rest;

import com.ozgurbayrasa.springrestdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstruct to load the student data only once.
    @PostConstruct
    public void loadStudents(){
        this.theStudents = new ArrayList<>();

        theStudents.add(new Student("ozgur", "bayrasa"));
        theStudents.add(new Student("selim", "bey"));
        theStudents.add(new Student("kazım", "fırat"));
    }

    // define endpoint for "/students" - return a list of students.

    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    // define endpoint for "/students/{studentId}" - return student at index.
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        // Check if student id is in the range.
        System.out.println(theStudents.size());
        if((studentId >= theStudents.size() || studentId < 0)){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        // just index into the list.
        return theStudents.get(studentId);
    }


}
