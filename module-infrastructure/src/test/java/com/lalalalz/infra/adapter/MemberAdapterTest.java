package com.lalalalz.infra.adapter;

import com.lalalalz.domain.member.Member;
import com.lalalalz.infra.adapter.out.LoadMemberAdapter;
import com.lalalalz.infra.adapter.out.SaveMemberAdapter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
class MemberAdapterTest {

    @Autowired
    LoadMemberAdapter loadMemberAdapter;
    @Autowired
    SaveMemberAdapter saveMemberAdapter;

    @Test
    void 회원_저장() {
        // given
        String email = "test@test.com";
        String password = "123";
        Member saved = saveMemberAdapter.save(Member.withoutId(email, password));

        // when
        Member findOne = loadMemberAdapter
                .findByEmail(email)
                .orElseThrow();

        // then
        log.info("saved email: {}, password: {}", saved.getEmail(), saved.getPassword());
        log.info("findOne email: {}, password: {}", findOne.getEmail(), findOne.getPassword());

        assertThat(findOne).extracting("email").isEqualTo(email);
        assertThat(findOne).extracting("password").isEqualTo(password);
    }
}