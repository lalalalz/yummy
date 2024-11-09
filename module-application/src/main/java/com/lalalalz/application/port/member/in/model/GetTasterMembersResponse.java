package com.lalalalz.application.port.member.in.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetTasterMembersResponse {
    List<GetBestMemberResponse> bestMembers;
}
