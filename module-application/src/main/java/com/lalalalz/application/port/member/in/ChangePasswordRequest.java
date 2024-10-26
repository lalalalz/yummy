package com.lalalalz.application.port.member.in;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
@AllArgsConstructor
public class ChangePasswordRequest {

    @NotBlank @Email
    private String email;

    @NotBlank @Length(min = 10, max = 20)
    private String password;

    @NotBlank @Length(min = 10, max = 20)
    private String newPassword;
}
