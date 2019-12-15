package com.dapeng_szz.cn.commons.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class LogActive {

    private final static Logger logger = LoggerFactory.getLogger(LogActive.class);

    @Pointcut("execution(* com.dapeng_szz.cn.controller.*.* (..))")
    public void pointcut(){};

    @Around(value = "pointcut()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        logger.info("Controller 调用方法==>"+methodName);
        Object proceed=null;
        try {
            proceed= joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            logger.error(methodName+"异常抛出");
        }finally {
            logger.info("Controller 结束返回值==>"+proceed);
            return proceed;
        }
    }
}
