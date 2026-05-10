package com.duoc.LearningPlatformValidation.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* com.duoc.LearningPlatformValidation.services.*.*(..))")
    public Object logMetodo(ProceedingJoinPoint joinPoint) throws Throwable {

        String metodo = joinPoint.getSignature().getName();
        long inicio = System.currentTimeMillis();

        System.out.println("[LOG] Ejecutando: " + metodo);

        Object resultado = joinPoint.proceed();

        long duracion = System.currentTimeMillis() - inicio;
        System.out.println("[LOG] " + metodo + " completado en " + duracion + "ms");

        return resultado;
    }
}