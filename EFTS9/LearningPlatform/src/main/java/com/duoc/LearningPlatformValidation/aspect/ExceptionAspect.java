package com.duoc.LearningPlatformValidation.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionAspect {

    @AfterThrowing(
        pointcut = "execution(* com.duoc.LearningPlatformValidation.services.*.*(..))",
        throwing = "ex"
    )
    public void logError(JoinPoint joinPoint, Exception ex) {
        String metodo = joinPoint.getSignature().getName();
        System.out.println("[ERROR] Fallo en: " + metodo + " → " + ex.getMessage());
    }
}