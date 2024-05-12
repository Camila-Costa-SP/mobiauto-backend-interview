package com.mobiauto.auth.annotation;

import com.mobiauto.auth.annotation.validation.ResaleValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Constraint(validatedBy = ResaleValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidResaleRequirement {
    String message() default "Invalid resale requirements for the given user role.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}