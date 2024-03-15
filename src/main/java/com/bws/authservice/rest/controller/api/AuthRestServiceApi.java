package com.bws.authservice.rest.controller.api;

import com.bws.authservice.api.request.AuthUserRequest;
import com.bws.authservice.api.request.UserAddRequest;
import com.bws.authservice.api.response.AuthUserResponse;
import com.bws.authservice.api.response.BaseResponse;
import com.bws.authservice.model.constants.PropertyConstants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthRestServiceApi {

    @PostMapping(path = PropertyConstants.REQUEST_NOTLOCKED_AUTHUSER, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<AuthUserResponse> authUser (@Valid @RequestBody AuthUserRequest authUserRequest, HttpServletRequest request , BindingResult bindingResult);

    @PostMapping(path = PropertyConstants.REQUEST_NOTLOCKED_REGISTERUSER, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BaseResponse> registerUser (@Valid @RequestBody UserAddRequest userAddRequest, HttpServletRequest request, BindingResult bindingResult);
}
