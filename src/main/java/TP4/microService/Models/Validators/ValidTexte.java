package TP4.microService.Models.Validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TexteValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidTexte {
    String message() default "Le champ ne doit contenir que des lettres, chiffres, espaces ou tirets";
    int min() default 2;
    int max() default 50;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
