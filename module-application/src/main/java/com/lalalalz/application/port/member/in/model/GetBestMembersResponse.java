package com.lalalalz.application.port.member.in.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetBestMembersResponse {
    List<GetBestMemberResponse> bestMembers;
}
