package TP4.microService.Models.Validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MatriculeValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMatricule {
    String message() default "Le numéro de matricule doit respecter le format SIV (ex: AB-123-CD)";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
