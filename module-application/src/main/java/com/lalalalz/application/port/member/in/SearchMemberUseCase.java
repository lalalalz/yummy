package com.lalalalz.application.port.member.in;

import com.lalalalz.application.port.member.in.model.*;

public interface SearchMemberUseCase {

    GetMemberResponse getMember(GetMemberRequest getMemberRequest);

    GetMembersResponse getMembers(GetMembersRequest getMembersRequest);

    GetBestMembersResponse getBestMembers(GetBestMembersRequest getBestMembersRequest);

}
