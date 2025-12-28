package com.examly.springapp.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceLoggingAspect {
    @Before("execution(* com.examly.springapp.service.*.*(..))")
    public void logServiceEntry(JoinPoint joinPoint) {
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        logger.info("Entering: {} with args: {}",joinPoint.getSignature().getName(),Arrays.toString(joinPoint.getArgs()));
    }

    @After("execution(* com.examly.springapp.service.*.*(..))")
    public void logServiceExit(JoinPoint joinPoint) {
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        logger.info("Entering: {} with args: {}",joinPoint.getSignature().getName(),Arrays.toString(joinPoint.getArgs()));
    }
}