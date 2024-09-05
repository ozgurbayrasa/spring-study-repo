package com.ozgurbayrasa.aopdemo.aspect;

import com.ozgurbayrasa.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;


// Add @Aspect annotation and @Component annotation.
@Aspect
@Order(2)
@Component
public class MyDemoLoggingAspect {

    // Add new advice for @After on the findAccounts method.
    @After("execution(* com.ozgurbayrasa.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){
        // Point out which method we are advising on.
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n======>>> Executing @AfterThrowing advice on method: " + method);
    }

    // Add new advice for @AfterThrowing on the findAccounts method.

    @AfterThrowing(
            pointcut = "execution(* com.ozgurbayrasa.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExc){

        // Point out which method we are advising on.
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n======>>> Executing @AfterThrowing advice on method: " + method);

        // Log the exception.
        System.out.println("\n======>>>Exception is: " + theExc);
    }

    // Add new advice for @AfterReturning on the findAccounts method.
    @AfterReturning(
            pointcut = "execution(* com.ozgurbayrasa.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result){
        // Point out which method we are advising on.
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n======>>> Executing @AfterReturning advice on method: " + method);

        // Print out the results of the method call.
        System.out.println("\n======>>>Returned: " + result);

        // Let's Post-process the data

        // Convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

        System.out.println("\n======>>>Result is: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        // Loop through accounts.

        for(Account tempAccount : result){
            // Get uppercase version of name.
            String theUpperName = tempAccount.getName().toUpperCase();

            // Update the name on the account.
            tempAccount.setName(theUpperName);
        }
    }

    @Before("com.ozgurbayrasa.aopdemo.aspect.PointcutExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){
        System.out.println("\n======>>> Executing @Before advice on method.");


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

    }

}
