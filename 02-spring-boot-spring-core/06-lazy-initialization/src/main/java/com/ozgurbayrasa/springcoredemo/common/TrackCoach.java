package com.ozgurbayrasa.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // Primary annotation
public class TrackCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Run a Hard 5k!";
    }
}
