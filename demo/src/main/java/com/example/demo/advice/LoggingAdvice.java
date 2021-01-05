package com.example.demo.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;

@Aspect
@Component
public class LoggingAdvice {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @AfterThrowing(pointcut = "execution(* com.example.demo.*.*.*(..))",throwing = "exception")
    public void applicationLogger(JoinPoint joinPoint, Throwable exception)  {
        String className = joinPoint.getTarget().getClass().toString();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
//        log.info("method invoked : "+className + " : " + methodName + "() arguments" + new ObjectMapper().writeValueAsString(args));
//        StringWriter stringWriter = new StringWriter();
//        PrintWriter printWriter = new PrintWriter(stringWriter);
//        exception.printStackTrace(printWriter);
//        String stackTrace = stringWriter.toString();
        log.error("Exception : ",exception);
    }

//    @Pointcut(value = "execution(* com.example.demo.*.*.*(..))")
//    public void myPointCut(){
//
//    }
//
//    @Around("myPointCut()")
//    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
//        ObjectMapper objectMapper = new ObjectMapper();
//        String className = pjp.getTarget().getClass().toString();
//        String methodName = pjp.getSignature().getName();
//        Object[] args = pjp.getArgs();
//        log.info("method invoked : "+className + " : " + methodName + "() arguments" + objectMapper.writeValueAsString(args));
//        Object object = pjp.proceed();
//        log.info(className + " : " + methodName + "() arguments" + objectMapper.writeValueAsString(object));
//        return object;
//    }
}
