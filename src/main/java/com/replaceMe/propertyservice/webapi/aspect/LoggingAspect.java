package com.replaceMe.propertyservice.webapi.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* com.replaceMe..*(..))") // Replace with your base package
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        // Proceed with method execution
        Object result = joinPoint.proceed();

        long elapsedTime = System.currentTimeMillis() - start;
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();

        logger.info(() -> String.format(
                "Executed %s.%s in %d ms",
                className,
                methodName,
                elapsedTime
        ));

        return result;
    }
}
