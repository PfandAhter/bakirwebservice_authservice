package com.bws.authservice.rest.service.interfaces;

import com.bws.authservice.api.request.ChangePwByCodeRequest;
import com.bws.authservice.api.request.ForgetPasswordRequest;
import com.bws.authservice.api.request.PasswordChangeRequest;
import com.bws.authservice.api.response.BaseResponse;
import com.bws.authservice.exceptions.PasswordNotMatchedException;

public interface IPasswordService {

    BaseResponse changePassword (PasswordChangeRequest request) throws PasswordNotMatchedException;

    BaseResponse forgetPassword (ForgetPasswordRequest request);

    BaseResponse changePwByCode (ChangePwByCodeRequest request);
}
