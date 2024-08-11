package com.ozgurbayrasa.springcoredemo.config;

import com.ozgurbayrasa.springcoredemo.common.Coach;
import com.ozgurbayrasa.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
