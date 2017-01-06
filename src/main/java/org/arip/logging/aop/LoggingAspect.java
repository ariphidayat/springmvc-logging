package org.arip.logging.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by Arip Hidayat on 1/6/2017.
 */
@Aspect
@Component
public class LoggingAspect {

    @AfterReturning("execution(* org.arip.logging.service.*.*(..))")
    public void log(JoinPoint joinPoint) {
        System.out.println("* log() is running!");
        System.out.println("* hijacked : " + joinPoint.getSignature().getName());
    }
}
