package com.accenture.bankledger.dto.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DateValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDate {

    String message() default "Date must be in dd/MM/yyyy format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}