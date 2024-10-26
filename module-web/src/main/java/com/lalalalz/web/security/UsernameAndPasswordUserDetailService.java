package com.lalalalz.web.security;

import com.lalalalz.application.port.member.out.LoadMemberPort;
import com.lalalalz.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class UsernameAndPasswordUserDetailService implements UserDetailsService {

    private final LoadMemberPort loadMemberPort;

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        Member member = loadMemberPort.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));

        return User.builder()
                .username(member.getEmail())
                .password(member.getPassword())
                .build();
    }
}
