package com.lalalalz.application.port.member.in.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import static com.lalalalz.domain.member.policy.MemberPasswordLengthPolicy.max;
import static com.lalalalz.domain.member.policy.MemberPasswordLengthPolicy.min;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordRequest {

    @NotBlank @Email
    private String email;

    @NotBlank @Length(min = min, max = max)
    private String password;

    @NotBlank @Length(min = min, max = max)
    private String newPassword;
}
