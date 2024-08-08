package com.ozgurbayrasa.springcoredemo.rest;

import com.ozgurbayrasa.util.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // Define a private field for dependency.
    private Coach myCoach;

    // Define a constructor for dependency injection
    // Autowired is optional if you have one injection.
    @Autowired
    DemoController(Coach coachParam){
        myCoach = coachParam;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
