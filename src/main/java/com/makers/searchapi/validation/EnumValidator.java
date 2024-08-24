package com.makers.searchapi.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnumValidator implements ConstraintValidator<EnumValid, String> {

    private Class<? extends Enum<?>> enumClass;

    @Override
    public void initialize(EnumValid annotation) {
        this.enumClass = annotation.enumClass();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true; // Allow null or empty values if optional
        }
        for (Enum<?> enumValue : enumClass.getEnumConstants()) {
            if (enumValue.name().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }
}
