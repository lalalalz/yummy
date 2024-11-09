package com.lalalalz.web.home.controller;

import com.lalalalz.application.port.member.in.SearchMemberUseCase;
import com.lalalalz.application.port.member.in.model.GetTasterMembersRequest;
import com.lalalalz.application.port.member.in.model.GetTasterMembersResponse;
import com.lalalalz.web.common.ResponseBody;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final SearchMemberUseCase searchMemberUseCase;

    @GetMapping("/home/taster")
    public ResponseBody<GetTasterMembersResponse> getTaster(@ModelAttribute GetTasterMembersRequest getTasterMembersRequest) {
        return ResponseBody.ok(searchMemberUseCase.getTasterMembers(getTasterMembersRequest));
    }
}
