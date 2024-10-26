package com.lalalalz.application.port.member.out;

import com.lalalalz.domain.member.Member;

import java.util.Optional;

public interface LoadMemberPort {

    Optional<String> findEmail(String email);

    Optional<Member> findByEmail(String email);
}
