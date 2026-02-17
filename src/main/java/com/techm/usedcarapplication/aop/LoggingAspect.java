package com.techm.usedcarapplication.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @AfterReturning(pointcut = "execution(* com.techm.usedcarapplication.controller.*.*(..))", returning = "result")
    public void logAfterReturningController(Object result) {
        System.out.println("Logging after the successful execution of Controller with result: " + result);
    }

    @AfterReturning(pointcut = "execution(* com.techm.usedcarapplication.repo.*.*(..))", returning = "result")
    public void logAfterReturningRepo(Object result) {
        System.out.println("Logging after the successful execution of Repository with result: " + result);
    }

    @AfterThrowing(pointcut = "execution(* com.techm.usedcarapplication.controller.*.*(..))", throwing = "exception")
    public void logAfterThrowingController(Exception exception) {
        System.out.println("Exception occurred in Controller: " + exception.getMessage());
    }

    @AfterThrowing(pointcut = "execution(* com.techm.usedcarapplication.repo.*.*(..))", throwing = "exception")
    public void logAfterThrowingRepo(Exception exception) {
        System.out.println("Exception occurred in Repository: " + exception.getMessage());
    }

    @AfterReturning("execution(* com.techm.usedcarapplication.*.*(..))")
    public void logUnspecifiedRequest() {
        System.out.println("Logging for unspecified request.");
    }
}
