package TP4.microService.Models.Validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TexteValidator implements ConstraintValidator<ValidTexte, String> {

    private static final String TEXTE_PATTERN = "^[a-zA-ZÀ-ÿ0-9 \\-]+$";
    private int min;
    private int max;

    @Override
    public void initialize(ValidTexte annotation) {
        this.min = annotation.min();
        this.max = annotation.max();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) {
            return false;
        }
        String trimmed = value.trim();
        if (trimmed.length() < min || trimmed.length() > max) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    "La longueur doit être comprise entre " + min + " et " + max + " caractères"
            ).addConstraintViolation();
            return false;
        }
        return trimmed.matches(TEXTE_PATTERN);
    }
}
