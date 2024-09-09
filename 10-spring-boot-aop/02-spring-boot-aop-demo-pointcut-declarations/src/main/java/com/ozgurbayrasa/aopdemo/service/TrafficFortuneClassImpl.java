package com.ozgurbayrasa.aopdemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneClassImpl implements TrafficFortuneService{
    @Override
    public String getFortune() {

        // Simulate a delay.
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "Expect heavy traffic this morning";
        // Return the fortune.
    }

    @Override
    public String getFortune(boolean tripWire) {
        if(tripWire){
            throw new RuntimeException("Major accident! Highway is closed!" );
        }
        return getFortune();
    }
}
