package com.ozgurbayrasa.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// Add @Aspect annotation and @Component annotation.
@Aspect
@Component
public class MyDemoLoggingAspect {

    // We add all of our related advices for logging.

    // Let's start with a @Before advice

    @Pointcut("execution(* com.ozgurbayrasa.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    // Pointcut Expression: Match any method in dao package with any parameters.
    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n======>>> Executing @Before advice on method.");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics(){
        System.out.println("\n======>>> Executing api analytics.");
    }



}
