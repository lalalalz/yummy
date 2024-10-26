package com.lalalalz.application.port.member.in.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetMemberRequest {

    @NotBlank @Email
    @Length(min = 10, max = 20)
    private String email;
}
