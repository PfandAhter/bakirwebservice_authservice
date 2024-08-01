package com.bws.authservice.rest.service.interfaces;

import com.bws.authservice.api.request.AuthUserRequest;
import com.bws.authservice.api.request.BaseRequest;
import com.bws.authservice.api.request.SellerAddRequest;
import com.bws.authservice.api.request.UserAddRequest;
import com.bws.authservice.api.response.AuthUserResponse;
import com.bws.authservice.api.response.BaseResponse;
import com.bws.authservice.exceptions.UserNotActiveException;

public interface IAuthService {

    BaseResponse createUser(UserAddRequest request);

    AuthUserResponse authUser(AuthUserRequest request) throws UserNotActiveException;

    BaseResponse logoutUser (BaseRequest baseRequest);

    BaseResponse registerSeller (SellerAddRequest request);
}
