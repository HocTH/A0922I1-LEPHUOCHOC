package com.example.nasa.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Component
@Aspect
public class LogAspect {
    private Logger logger = Logger.getLogger(LogAspect.class.getName());
    @Pointcut("execution (* com.example.nasa.service.CommentServiceImpl.*(..))")
    public void commentService(){};
    @Before("commentService()")
    public void writeLogNasaService(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Before: " + methodName);
    }
    @Around("execution (* com.example.nasa.service.CommentServiceImpl.findAll())")
    public Object writeLogFindAll(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Around before call: " + methodName);
        Object result = joinPoint.proceed();
        logger.info("Around after call: " + methodName);
        return result;
    }
    @AfterThrowing(pointcut = "execution (* com.example.nasa.service.CommentServiceImpl.*(..))", throwing = "e")
    public void log(JoinPoint joinPoint, Exception e) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[CMS] co loi xay ra: %s.%s%s: %s", className, method, args, e.getMessage()));
    }
}
