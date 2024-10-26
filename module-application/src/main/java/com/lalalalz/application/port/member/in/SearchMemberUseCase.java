package com.lalalalz.application.port.member.in;

import com.lalalalz.application.port.member.in.model.GetMemberRequest;
import com.lalalalz.application.port.member.in.model.GetMemberResponse;
import com.lalalalz.application.port.member.in.model.GetMembersRequest;
import com.lalalalz.application.port.member.in.model.GetMembersResponse;

public interface SearchMemberUseCase {

    GetMemberResponse getMember(GetMemberRequest getMemberRequest);

    GetMembersResponse getMembers(GetMembersRequest getMembersRequest);

}
