package com.bws.authservice.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PasswordChangeRequest extends BaseRequest {

    private String oldPassword;
    private String newPassword;
    private String newPasswordAgain;

}

