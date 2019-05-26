package com.lyx.lab.web.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
public class MethodExecutionCalculationAspect {

    @Around("@annotation(com.lyx.lab.annotation.TrackTime)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object obj = joinPoint.proceed();

        long timeTaken = System.currentTimeMillis() - startTime;
        log.info("Time Taken by {} is {} ms", joinPoint, timeTaken);

        return obj;
    }

}
