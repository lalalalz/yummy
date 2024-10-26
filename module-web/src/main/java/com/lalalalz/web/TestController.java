package com.lalalalz.web;

import com.lalalalz.application.port.member.in.CreateMemberUseCase;
import com.lalalalz.application.port.member.in.model.CreateMemberRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class TestController {

    private final CreateMemberUseCase createMemberUseCase;

    @GetMapping("/hello")
    public String test(final Model model) {
        model.addAttribute("item", "안녕 나는 테스트");
        return "hello";
    }

    @GetMapping("/join")
    public String joinView() {
        return "join";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute final JoinForm joinForm) {
        createMemberUseCase.createMember(new CreateMemberRequest(joinForm.getEmail(), "{noop}" + joinForm.getPassword()));
        return "redirect:/";
    }
}
