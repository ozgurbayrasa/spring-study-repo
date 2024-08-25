package com.ozgurbayrasa.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // Need a controller method to show initial HTML Form.
    @GetMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }


    // Need a controller method to process the HTML form.
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    // Need a controller method to read form data
    // and add that data to the model.
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){

        // Read request parameter from the HTML form.
        String theName = request.getParameter("studentName");

        // Convert the data all caps.
        theName = theName.toUpperCase();

        // Create the message.
        String result = "Yo " + theName + "!";

        // Add message to the model.
        model.addAttribute("message", result);

        return "helloworld";
    }

    @PostMapping ("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName,
                                          Model model){
        // Convert the data all caps.
        theName = theName.toUpperCase();

        // Create the message.
        String result = "Hey my friend " + theName + "!";

        // Add message to the model.
        model.addAttribute("message", result);

        return "helloworld";
    }
}
