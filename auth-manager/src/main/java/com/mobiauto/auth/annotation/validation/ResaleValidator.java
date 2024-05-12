package com.mobiauto.auth.annotation.validation;

import com.mobiauto.auth.annotation.ValidResaleRequirement;
import com.mobiauto.auth.dto.UserRequestDto;
import com.mobiauto.auth.enums.Roles;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
public class ResaleValidator implements ConstraintValidator<ValidResaleRequirement, UserRequestDto> {
    @Override
    public void initialize(ValidResaleRequirement constraintAnnotation) {
    }
    @Override
    public boolean isValid(UserRequestDto context, ConstraintValidatorContext cvc) {
        if (context.role() == Roles.ADMIN) {
            return true;
        }
        return context.resaleIds() != null && !context.resaleIds().isEmpty();
    }
}