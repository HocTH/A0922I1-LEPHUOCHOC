package codegym.vn.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LogAspect {
    private Logger logger = Logger.getLogger(LogAspect.class.getName());

    @Pointcut("execution (* codegym.vn.service.ProductService.*(..))")
    public void productService() {};

    @Before("productService()")
    public void writeLogProductService(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Before: " + methodName);
    }

    @Around("execution (* codegym.vn.service.ProductService.findAll())")
    public Object writeLogFindAll(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Around before call: " + methodName);
        Object result = joinPoint.proceed();
        logger.info("Around after call: " + methodName);
        return result;
    }
}
