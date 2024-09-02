package com.ozgurbayrasa.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// Add @Aspect annotation and @Component annotation.
@Aspect
@Component
public class MyDemoLoggingAspect {

    // We add all of our related advices for logging.

    // Let's start with a @Before advice

    /*
    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice(){
        System.out.println("/n======>>> Executing @Before advice on addAccount()");
    }
     */

    // Pointcut Expression: Match method specific to a class.

    /*
    @Before("execution(public void com.ozgurbayrasa.aopdemo.dao.AccountDAOImpl.addAccount())")
    public void beforeAddAccountAdvice(){
        System.out.println("\n======>>> Executing @Before advice on addAccount()");
    }
    */

    // Pointcut Expression: Match any void method starts with add.
    @Before("execution(void add*())")
    public void beforeAddAccountAdvice(){
        System.out.println("\n======>>> Executing @Before advice on method.");
    }




}
