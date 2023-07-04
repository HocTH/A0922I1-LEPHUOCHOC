package com.example.bookapp.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class Logger {
    //dto
    //execution khớp những join point là những điểm thực thi phương thức
    @After("execution(* com.example.bookapp.controller.BookController.doBorrow(..))")
    public void logAfterMethodController(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        System.err.println("The method just called is:" + method);
    }

    private int countVisitor = 0;
    //within khớp join trong 1 phạm vi cụ thể như 1 package hay class

    @Pointcut("within(com.example.bookapp.controller.BookController*)")
    public void allControllerPointCut() {
    }

    @After("allControllerPointCut()()")
    public void countVisitor() {
        System.out.println("------------------");
        System.err.println("The number of visitor = " + ++countVisitor);
    }


}
