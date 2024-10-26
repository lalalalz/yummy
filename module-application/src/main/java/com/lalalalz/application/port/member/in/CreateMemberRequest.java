package com.lalalalz.application.port.member.in;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
@AllArgsConstructor
public class CreateMemberRequest {

    @NotBlank @Email
    private String email;

    @NotBlank @Length(min = 10, max = 20)
    private String password;

//    @NotBlank @Length(min = 3, max = 20)
//    private String name;
//
//    @NotBlank @Pattern(regexp = "^01[016789]\\d{3,4}\\d{4}$")
//    private String phone;
}
