package com.lalalalz.application.port.member.in.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetMembersRequest {

    @NotNull
    @Size(min = 0, max = 100)
    private List<String> emails;
}
