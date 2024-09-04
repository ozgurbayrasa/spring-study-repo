package com.ozgurbayrasa.aopdemo.aspect;

import com.ozgurbayrasa.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



// Add @Aspect annotation and @Component annotation.
@Aspect
@Order(2)
@Component
public class MyDemoLoggingAspect {

    @Before("com.ozgurbayrasa.aopdemo.aspect.PointcutExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){

        // Display the method signature.
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method Signature: " + methodSignature);

        // Display the method arguments.

        // Get arguments.
        Object[] args = joinPoint.getArgs();

        // Loop arguments.
        for(Object tempArg : args){
            System.out.println(tempArg);

            if(tempArg instanceof Account theAccount){
                System.out.println("Downcasting to Account...");
                System.out.println("Account name: " + theAccount.getName());
                System.out.println("Account level: " + theAccount.getLevel());
            }
        }

        System.out.println("\n======>>> Executing @Before advice on method.");
    }

}
