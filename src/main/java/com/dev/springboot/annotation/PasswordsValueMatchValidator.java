package com.dev.springboot.annotation;

import com.dev.springboot.dto.user.UserRequestDto;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordsValueMatchValidator implements
        ConstraintValidator<PasswordsValueMatch, UserRequestDto> {
    @Override
    public boolean isValid(UserRequestDto userRegistrationDto,
                           ConstraintValidatorContext constraintValidatorContext) {
        String password = userRegistrationDto.getPassword();
        String repeatPassword = userRegistrationDto.getRepeatPassword();
        return password != null && password.equals(repeatPassword);
    }
}
