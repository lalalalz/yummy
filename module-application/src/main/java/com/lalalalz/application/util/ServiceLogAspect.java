package com.lalalalz.application.util;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ServiceLogAspect {

    @Pointcut("execution (* com.lalalalz.application..*(..))")
    public void allApplication() {}

    @Around("allApplication()")
    public Object doLog(final ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();

        log.info("[mylog IN ] : {}", signature.getName());
        Object proceed = joinPoint.proceed();
        log.info("[mylog OUT] : {}", signature.getName());
        return proceed;
    }
}
