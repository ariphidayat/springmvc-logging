package org.arip.logging.aop;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by Arip Hidayat on 1/6/2017.
 */
@Aspect
@Component
public class LoggingAspect {

    @AfterReturning(
            pointcut = "execution(* org.arip.logging.service.*.*(..))",
            returning = "result")
    public void log(JoinPoint joinPoint, Object result) throws IOException {
        System.out.println("* log() is running!");
        System.out.println("* hijacked : " + joinPoint.getSignature().getName());

        System.out.println("* result : " + result);
        System.out.println("* result.getClass : " + result.getClass());

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(result);
        System.out.println("* json : " + jsonString);

        JsonNode node = mapper.readTree(jsonString);
        System.out.println("* node \"name\" : " + node.path("name").asText());
    }
}
