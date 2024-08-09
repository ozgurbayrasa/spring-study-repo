package com.ozgurbayrasa.springcoredemo.rest;

import com.ozgurbayrasa.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // Define a private field for dependency.
    private Coach myCoach;

    @Autowired
    public void setCoach(Coach coachParam){
        myCoach = coachParam;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
