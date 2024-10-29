package com.lalalalz.web.join.controller;

import com.lalalalz.application.port.member.in.CreateMemberUseCase;
import com.lalalalz.application.port.member.in.model.CreateMemberRequest;
import com.lalalalz.application.port.member.in.model.CreateMemberResponse;
import com.lalalalz.web.join.dto.JoinRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class JoinController {

    private final CreateMemberUseCase createMemberUseCase;

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute JoinRequest joinRequest) {
        CreateMemberRequest createMemberRequest = new CreateMemberRequest(
                joinRequest.getEmail(),
                joinRequest.getPassword());

        CreateMemberResponse createMemberResponse = createMemberUseCase.createMember(createMemberRequest);

        return "redirect:/login";
    }
}
