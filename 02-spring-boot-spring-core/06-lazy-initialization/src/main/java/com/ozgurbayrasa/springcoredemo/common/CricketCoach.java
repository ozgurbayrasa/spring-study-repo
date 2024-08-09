package com.ozgurbayrasa.springcoredemo.common;

import org.springframework.stereotype.Component;

// Marks the class as Spring Bean to be allowed
// for injection.
@Component
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practise fast bowling for 20 minutes.";
    }
}
