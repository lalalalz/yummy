package com.lalalalz.application.port.member.in;

import com.lalalalz.application.port.member.in.model.CreateMemberRequest;
import com.lalalalz.application.port.member.in.model.CreateMemberResponse;

public interface CreateMemberUseCase {
    CreateMemberResponse createMember(CreateMemberRequest createMemberRequest);
}
