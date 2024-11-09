package com.lalalalz.application.port.member.out;

import com.lalalalz.application.port.member.in.model.GetBestMemberResponse;
import com.lalalalz.application.port.member.in.model.GetMemberResponse;
import com.lalalalz.domain.member.Member;

import java.util.List;
import java.util.Optional;

public interface LoadMemberPort {

    Optional<String> findEmail(String email);
    Optional<Member> findByEmail(String email);
    List<GetMemberResponse> searchMembersByEmail(List<String> emails);
    List<GetBestMemberResponse> findTasterMembers(Long count);
}
