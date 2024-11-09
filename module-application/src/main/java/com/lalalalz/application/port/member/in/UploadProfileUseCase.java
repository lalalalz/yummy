package com.lalalalz.application.port.member.in;

import com.lalalalz.application.port.member.in.model.UploadProfileRequest;
import com.lalalalz.application.port.member.in.model.UploadProfileResponse;

public interface UploadProfileUseCase {

    UploadProfileResponse uploadProfile(UploadProfileRequest uploadProfileRequest);

}
