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

    // Create pointcut declaration.
    @Pointcut("execution(* com.ozgurbayrasa.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    // Create pointcut for getter/setters.
    @Pointcut("execution(* com.ozgurbayrasa.aopdemo.dao.*.get*(..))")
    private void forDaoPackageGetter(){}

    @Pointcut("execution(* com.ozgurbayrasa.aopdemo.dao.*.set*(..))")
    private void forDaoPackageSetter(){}

    // Create pointcut for all methods in dao excluding getters/setters.
    @Pointcut("forDaoPackage() && !(forDaoPackageGetter() || forDaoPackageSetter())")
    private void forDaoPackageNoGetterSetter(){}

    // Pointcut declaration usage.
    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n======>>> Executing @Before advice on method.");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("\n======>>> Executing api analytics.");
    }



}
