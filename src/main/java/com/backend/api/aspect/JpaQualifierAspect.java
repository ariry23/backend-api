package com.backend.api.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.backend.api.annotation.JpaQualifier;

@Aspect
@Component
public class JpaQualifierAspect {
@Around("execution(* *(..)) && @target(customAnnotation)")
    public Object around(ProceedingJoinPoint joinPoint, JpaQualifier jpaQualifier) throws Throwable {
        String value = jpaQualifier.value();
        Object[] args = joinPoint.getArgs();

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Class<?> declaringClass = methodSignature.getDeclaringType();

        if (declaringClass.getSuperclass().isAnnotationPresent(JpaQualifier.class)) {
            JpaQualifier parentAnnotation = declaringClass.getSuperclass().getAnnotation(JpaQualifier.class);
            String parentValue = parentAnnotation.value();
            // Modify arguments or context based on the parent's annotation value if needed
        }

        if (args.length > 0 && args[0] instanceof String) {
            args[0] = value;  // Pass the annotation value as the first method argument
        }

        return joinPoint.proceed(args);
    }
}
