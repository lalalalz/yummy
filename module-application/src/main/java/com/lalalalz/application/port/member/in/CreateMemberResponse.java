package com.lalalalz.application.port.member.in;

import com.lalalalz.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class CreateMemberResponse {

    private Long id;

    public static CreateMemberResponse from(final Member member) {
        return new CreateMemberResponse(member.getId());
    }
}
