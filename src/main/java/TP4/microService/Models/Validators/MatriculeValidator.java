package TP4.microService.Models.Validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MatriculeValidator implements ConstraintValidator<ValidMatricule, String> {

    private static final String SIV_PATTERN = "^[A-Z]{2}-[0-9]{3}-[A-Z]{2}$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) {
            return false;
        }
        return value.toUpperCase().matches(SIV_PATTERN);
    }
}
