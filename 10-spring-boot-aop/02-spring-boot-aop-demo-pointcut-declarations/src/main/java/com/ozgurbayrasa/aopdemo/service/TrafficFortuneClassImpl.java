package com.ozgurbayrasa.aopdemo.service;

import java.util.concurrent.TimeUnit;

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
}
