package com.bws.authservice.rest.service.interfaces;

import com.bws.authservice.api.request.AuthUserRequest;
import com.bws.authservice.api.request.UserAddRequest;
import com.bws.authservice.api.response.AuthUserResponse;
import com.bws.authservice.api.response.BaseResponse;

public interface IAuthService {

    BaseResponse createUser(UserAddRequest request);

    AuthUserResponse authUser(AuthUserRequest request);
}
