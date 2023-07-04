package com.example.phtotheofdayupdate2.logger;

import com.example.phtotheofdayupdate2.entity.Photo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.logging.Logger;


@Aspect
@Component
public class LoggerAspect {
    //    @After("execution(* com.example.phtotheofdayupdate2.controller.PhotoController.doCreate(..))")
//    public void logAfterMethodController(JoinPoint joinPoint) {
//        String args = Arrays.toString(joinPoint.getArgs());
//        String method = joinPoint.getSignature().getName();
//        System.err.println("The method just called is:" + method);
//
//    }
    private Logger logger = Logger.getLogger(LoggerAspect.class.getName());

    @AfterThrowing(pointcut = "execution(* com.example.phtotheofdayupdate2.controller.PhotoController.doCreate(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
//        String methodName = joinPoint.getSignature().getName();
//        String className = joinPoint.getTarget().getClass().getName();
        Object[] args = joinPoint.getArgs();
        Photo photo = (Photo) args[0];
        String author = photo.getNameAuthor();
        String feedbackContent = photo.getFeedBack();
        LocalDateTime feedbackTime = LocalDateTime.now();
        System.out.println("Exception in Author:" + author +";"+ "Feedback:" + feedbackContent +";"+ "Feedback time:" + feedbackTime);
    }


}
