package com.example.demo.annotation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TokenIsVaildValidator.class )
public @interface TokenIsVaild {

    String message() default "token自定义注解";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
