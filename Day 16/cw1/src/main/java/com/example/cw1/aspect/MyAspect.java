package com.example.cw1.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Before("execution(* com.example.cw1.service.MyService.doSomething())")
    public void beforeDoSomething() {
        System.out.println("Before advice: Executing before doSomething()");
    }

    @After("execution(* com.example.cw1.service.MyService.doSomething())")
    public void afterDoSomething() {
        System.out.println("After advice: Executing after doSomething()");
    }

    @Around("execution(* com.example.cw1.service.MyService.doSomething())")
    public void aroundDoSomething(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around advice: Executing before doSomething()");
        joinPoint.proceed();
        System.out.println("Around advice: Executing after doSomething()");
    }
}
