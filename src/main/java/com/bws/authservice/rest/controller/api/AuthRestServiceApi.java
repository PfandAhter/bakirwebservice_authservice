package com.bws.authservice.rest.controller.api;

import com.bws.authservice.api.request.*;
import com.bws.authservice.api.response.AuthUserResponse;
import com.bws.authservice.api.response.BaseResponse;
import com.bws.authservice.exceptions.PasswordNotMatchedException;
import com.bws.authservice.exceptions.UserNotActiveException;
import com.bws.authservice.model.constants.PropertyConstants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthRestServiceApi {

    @PostMapping(path = PropertyConstants.REQUEST_NOT_SECURE_REST_CONTROLLER_AUTH_SERVICE_LOGIN, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<AuthUserResponse> authUser (@Valid @RequestBody AuthUserRequest authUserRequest, HttpServletRequest request , BindingResult bindingResult) throws UserNotActiveException;

    @PostMapping(path = PropertyConstants.REQUEST_NOT_SECURE_REST_CONTROLLER_AUTH_SERVICE_REGISTER, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BaseResponse> registerUser (@Valid @RequestBody UserAddRequest userAddRequest, HttpServletRequest request, BindingResult bindingResult);

    @PostMapping(path = PropertyConstants.REQUEST_SECURE_REST_CONTROLLER_AUTH_SERVICE_CHANGE_PASSWORD , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BaseResponse> changePassword (@Valid @RequestBody PasswordChangeRequest passwordChangeRequest , HttpServletRequest request)throws PasswordNotMatchedException;

    @PostMapping(path = PropertyConstants.REQUEST_SECURE_REST_CONTROLLER_AUTH_SERVICE_LOGOUT , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BaseResponse> logoutUser (@Valid @RequestBody BaseRequest baseRequest , HttpServletRequest request);

    @PostMapping(path = PropertyConstants.REQUEST_NOT_SECURE_REST_CONTROLLER_AUTH_SERVICE_REGISTER_AS_SELLER , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BaseResponse> registerSeller (@Valid @RequestBody SellerAddRequest sellerAddRequest, HttpServletRequest request);

    @PostMapping(path = PropertyConstants.REQUEST_NOT_SECURE_REST_CONTROLLER_AUTH_SERVICE_FORGET_PASSWORD , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BaseResponse> forgetPassword (@Valid @RequestBody ForgetPasswordRequest forgetPasswordRequest , HttpServletRequest request);

    @PostMapping(path = PropertyConstants.REQUEST_NOT_SECURE_REST_CONTROLLER_AUTH_SERVICE_CHANGE_PW_BY_CODE , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BaseResponse> changePwByCode (@Valid @RequestBody ChangePwByCodeRequest changePwByCodeRequest ,HttpServletRequest request);
}
