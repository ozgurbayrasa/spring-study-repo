package com.ozgurbayrasa.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Which constraint validator you use? How to define validation?
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
// Where you can apply this annotation.
@Target({ElementType.FIELD, ElementType.METHOD})
// How long it will be marked, we say use it in runtime.
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    // Define default course code
    public String value() default "BAY";

    // Define default error message
    public String message() default "Must start with BAY";

    // Define default groups.
    // You can group related constraints.
    public Class<?>[] groups() default {};

    // Define default payloads.
    // Custom details about validation failure.
    public Class<? extends Payload>[] payload() default {};
}
