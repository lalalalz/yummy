package com.lalalalz.web.home.controller;

import com.lalalalz.application.port.member.in.SearchMemberUseCase;
import com.lalalalz.application.port.member.in.model.GetBestMembersRequest;
import com.lalalalz.application.port.member.in.model.GetBestMembersResponse;
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
    public ResponseBody<GetBestMembersResponse> getTaster(@ModelAttribute GetBestMembersRequest getBestMembersRequest) {
        return ResponseBody.ok(searchMemberUseCase.getBestMembers(getBestMembersRequest));
    }
}
