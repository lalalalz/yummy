package com.lalalalz.application.port.member.in;

import com.lalalalz.application.port.member.in.model.ChangePasswordRequest;
import com.lalalalz.application.port.member.in.model.ChangePasswordResponse;

public interface ChangePasswordUseCase {

    ChangePasswordResponse changePassword(ChangePasswordRequest changePasswordRequest);

}
