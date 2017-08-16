package org.arip.logging.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.arip.logging.model.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by Arip Hidayat on 1/6/2017.
 */
@Aspect
@Component
public class LoggingAspect {

    @After("@annotation(auditable)")
    public void log(JoinPoint joinPoint, Auditable auditable) throws Exception {
        for (Object obj: joinPoint.getArgs()) {
            getTargetAudit(obj);

            // Object to JSON String
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(obj);
            System.out.println("* JSON Object : " + jsonString);

            // JSON String to User Object
            Class userClazz = Class.forName("org.arip.logging.model.User");
            if (obj.getClass().equals(userClazz)) {
                User user = (User) mapper.readValue(jsonString, userClazz);
                System.out.println("* user.toString : " + user.toString());
                System.out.println("* user.getName  : " + user.getName());
            }

            System.out.println("* action type : " + auditable.actionType());
            System.out.println("* actionType().toString() : " + auditable.actionType().toString());
            System.out.println("----------------------------------");
        }
    }

    private void getTargetAudit(Object obj) throws Exception {
        Class clazz = obj.getClass();
        for (Field field: clazz.getDeclaredFields()) {
            for (Annotation annotation: field.getAnnotations()) {
                if (annotation.annotationType() == AuditTargetId.class) {
                    field.setAccessible(true);

                    Field annotatedFieldName = clazz.getDeclaredField(field.getName());
                    annotatedFieldName.setAccessible(true);

                    // Get field value
                    String annotatedFieldValue = (String) annotatedFieldName.get(obj);
                    System.out.println("* annotatedFieldValue.toString() : " + annotatedFieldValue);
                    System.out.println("* annotation.annotationType() : " + annotation.annotationType());
                }
            }
        }
    }
}
