package com.bws.authservice.rest.controller;

import com.bws.authservice.api.request.AuthUserRequest;
import com.bws.authservice.api.request.UserAddRequest;
import com.bws.authservice.api.response.AuthUserResponse;
import com.bws.authservice.api.response.BaseResponse;
import com.bws.authservice.model.constants.PropertyConstants;
import com.bws.authservice.rest.controller.api.AuthRestServiceApi;
import com.bws.authservice.rest.service.AuthServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = PropertyConstants.REQUEST_NOTLOCKED_AUTHSERVICE)
@RequiredArgsConstructor
@CrossOrigin

public class AuthServiceController implements AuthRestServiceApi {

    private final AuthServiceImpl authService;

    @Override
    public ResponseEntity<AuthUserResponse> authUser(AuthUserRequest authUserRequest, HttpServletRequest request , BindingResult bindingResult) {
        return ResponseEntity.ok(authService.authUser(authUserRequest));
    }

    @Override
    public ResponseEntity<BaseResponse> registerUser(UserAddRequest userAddRequest, HttpServletRequest request,BindingResult bindingResult) {
        return ResponseEntity.ok(authService.createUser(userAddRequest));
    }
}
