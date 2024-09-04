package com.ozgurbayrasa.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


// Add @Aspect annotation and @Component annotation.
@Aspect
@Order(2)
@Component
public class MyDemoLoggingAspect {

    @Before("com.ozgurbayrasa.aopdemo.aspect.PointcutExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n======>>> Executing @Before advice on method.");
    }

}
