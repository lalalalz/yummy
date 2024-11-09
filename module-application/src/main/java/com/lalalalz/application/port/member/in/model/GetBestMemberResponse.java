package com.lalalalz.application.port.member.in.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetBestMemberResponse {

    private String email;
    private String username;
    private boolean isTaster;
}
