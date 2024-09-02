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

    /*
    @Before("execution(void add*())")
    public void beforeAddAccountAdvice(){
        System.out.println("\n======>>> Executing @Before advice on method.");
    }

    */

    // Pointcut Expression: Match any method starting with add and
    // has one parameter with Account type

    /*
    @Before("execution(* add*(com.ozgurbayrasa.aopdemo.Account))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n======>>> Executing @Before advice on method.");
    }
    */

    /*
    // Pointcut Expression: Match any method starting with add and
    // has one parameter with Account type, also it can have any other parameters.
    @Before("execution(* add*(com.ozgurbayrasa.aopdemo.Account, ..))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n======>>> Executing @Before advice on method.");
    }

    */

    // Pointcut Expression: Match any method in dao package with any parameters.
    @Before("execution(* com.ozgurbayrasa.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n======>>> Executing @Before advice on method.");
    }




}
