package com.example.L10aopdemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {


    private static Logger logger = LoggerFactory.getLogger(ExecutionTimeAspect.class);

    @Around("@annotation(com.example.L10aopdemo.aop.LogExecutionTime)")
    public Object log(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = point.proceed();
        long executionTime = System.currentTimeMillis() - start;
        logger.error("Execution Time: {}",executionTime);
        return result;
    }

    @Before("execution(* com.example.L10aopdemo.TestController.*(..))")
    public void beforeMethod(){
        logger.error("Executing before method advice");
    }

    @After("execution(* com.example.L10aopdemo.TestController.*(..))")
    public void afterMethod(){
        logger.error("Executing after method advice");
    }


}
