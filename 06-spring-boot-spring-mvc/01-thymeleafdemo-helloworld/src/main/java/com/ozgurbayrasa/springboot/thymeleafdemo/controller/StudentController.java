package com.ozgurbayrasa.springboot.thymeleafdemo.controller;

import com.ozgurbayrasa.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> systems;

    @GetMapping("/showStudentForm")
    public String showForm(Model model){

        // Create a new student object.
        Student theStudent = new Student();

        // Add student object as model attribute.
        model.addAttribute("student", theStudent);

        // Add countries list to the model.
        model.addAttribute("countries", countries);

        // Add languages list to the model.
        model.addAttribute("languages", languages);

        // Add systems list to the model.
        model.addAttribute("systems", systems);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){

        // Log the input data.
        System.out.println("theStudent: " + theStudent.getFirstName()
                + " " + theStudent.getLastName());

        return "student-confirmation";
    }

}
