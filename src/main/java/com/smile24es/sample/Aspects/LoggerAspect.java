package com.smile24es.sample.Aspects;

import com.smile24es.sample.Annotations.AutoLoggable;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Aspect
@Component
public class LoggerAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerAspect.class);

    @Around(value = "@annotation(com.smile24es.sample.Annotations.AutoLoggable)")
    public Object autoLoggableHandler(ProceedingJoinPoint joinPoint) throws Throwable {

        Signature methodSignature = joinPoint.getSignature();
        MethodSignature signature = (MethodSignature) methodSignature;
        Method method = joinPoint.getTarget().getClass()
                .getMethod(signature.getMethod().getName(), signature.getMethod().getParameterTypes());
        AutoLoggable autoLoggable = method.getAnnotation(AutoLoggable.class);

        long start = System.currentTimeMillis();
        Object[] methodArguments = joinPoint.getArgs();

        if (autoLoggable != null && autoLoggable.isLogArgs()) {
            LOGGER.info("Start executing method [{}] with parameters [{}]", methodSignature, methodArguments);
        } else {
            LOGGER.info("Start executing method [{}]", methodSignature);
        }

        Object proceed = joinPoint.proceed();

        if (autoLoggable != null && autoLoggable.isLogArgs()) {
            LOGGER.info("Exiting from method [{}] with parameters [{}]", methodSignature, methodArguments);
        } else {
            LOGGER.info("Exiting from method [{}]", methodSignature);
        }

        long executionTime = System.currentTimeMillis() - start;
        if (autoLoggable != null && autoLoggable.isLogExecutionTime()) {
            LOGGER.info("The method [{}] executed in [{}] ms", methodSignature, executionTime);
        }

        return joinPoint.proceed();
    }
}
