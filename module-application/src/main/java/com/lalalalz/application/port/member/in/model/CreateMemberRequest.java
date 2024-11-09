package com.lalalalz.application.port.member.in.model;

import com.lalalalz.domain.member.Address;
import com.lalalalz.domain.member.Member;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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

    @NotBlank
    private String username;

    @NotBlank @Length(min = min, max = max)
    private String password;

    @NotBlank @Pattern(regexp = "") // todo
    private String phone;

    @NotBlank
    private String city;

    @NotBlank
    private String roadAddress;

    public Member of() {
        return Member.withoutId(email, username, password, phone, new Address(city, roadAddress));
    }
}
