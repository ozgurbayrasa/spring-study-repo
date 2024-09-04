package com.ozgurbayrasa.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PointcutExpressions {
    // We add all of our related advices for logging.

    // Let's start with a @Before advice

    // Create pointcut declaration.
    @Pointcut("execution(* com.ozgurbayrasa.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){}

    // Create pointcut for getter/setters.
    @Pointcut("execution(* com.ozgurbayrasa.aopdemo.dao.*.get*(..))")
    public void forDaoPackageGetter(){}

    @Pointcut("execution(* com.ozgurbayrasa.aopdemo.dao.*.set*(..))")
    public void forDaoPackageSetter(){}

    // Create pointcut for all methods in dao excluding getters/setters.
    @Pointcut("forDaoPackage() && !(forDaoPackageGetter() || forDaoPackageSetter())")
    public void forDaoPackageNoGetterSetter(){}
}
