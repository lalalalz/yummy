package com.lalalalz.infra.adapter.out.persistence;

import com.lalalalz.application.port.member.in.model.GetMemberResponse;

import java.util.List;
import java.util.Optional;

public interface MemberQueryDslRepository {
    Optional<String> findEmail(final String email);
    List<GetMemberResponse> searchMemberByEmail(List<String> emails);
}
