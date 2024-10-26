package com.lalalalz.application.port.member.in.model;

import com.lalalalz.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetMemberResponse {

    private String email;
    private String password;

    @NonNull
    public static GetMemberResponse from(@NonNull final Member member) {
        return new GetMemberResponse(member.getEmail(), member.getPassword());
    }
}
