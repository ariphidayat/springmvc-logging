package org.arip.logging.aop;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.arip.logging.model.User;
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

    @AfterReturning(pointcut = "@annotation(auditable)", returning = "result")
    public void log(JoinPoint joinPoint, Auditable auditable, Object result) throws IOException, ClassNotFoundException {
        System.out.println("----------------------------------");
        System.out.println("* hijacked : " + joinPoint.getSignature().getName());

        System.out.println("* result : " + result);
        System.out.println("* result.getClass : " + result.getClass());
        System.out.println("* result.getClass.getSimpleName : " + result.getClass().getSimpleName());

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(result);
        System.out.println("* JSON Object : " + jsonString);

        JsonNode node = mapper.readTree(jsonString);
        System.out.println("* JSON Node for \"name\" : " + node.path("name").asText());

        Class clazz = Class.forName("org.arip.logging.model.User");
        if (result.getClass().equals(clazz)) {
            User user = (User) mapper.readValue(jsonString, clazz);
            System.out.println("* user.toString : " + user.toString());
            System.out.println("* user.getName  : " + user.getName());
        }

        System.out.println("* action type : " + auditable.actionType());
        System.out.println("* actionType().toString() : " + auditable.actionType().toString());
        System.out.println("----------------------------------");
    }
}
