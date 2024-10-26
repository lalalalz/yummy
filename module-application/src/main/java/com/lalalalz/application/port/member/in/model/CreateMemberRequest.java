package com.lalalalz.application.port.member.in.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import static com.lalalalz.domain.member.MemberPasswordLengthPolicy.max;
import static com.lalalalz.domain.member.MemberPasswordLengthPolicy.min;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateMemberRequest {

    @NotBlank @Email
    private String email;

    @NotBlank @Length(min = min, max = max)
    private String password;

//    @NotBlank @Length(min = 3, max = 20)
//    private String name;
//
//    @NotBlank @Pattern(regexp = "^01[016789]\\d{3,4}\\d{4}$")
//    private String phone;
}
