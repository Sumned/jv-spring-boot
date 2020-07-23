package com.dev.springboot.dto.user;

import com.dev.springboot.annotation.EmailConstraint;
import com.dev.springboot.annotation.PasswordsValueMatch;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@PasswordsValueMatch
@Data
public class UserRequestDto {
    @NotNull
    @EmailConstraint
    private String email;

    @NotNull
    @Size(min = 5, message = "Password too short")
    private String password;

    private String repeatPassword;

}
