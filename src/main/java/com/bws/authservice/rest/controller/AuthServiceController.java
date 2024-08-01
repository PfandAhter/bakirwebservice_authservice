package com.bws.authservice.rest.controller;

import com.bws.authservice.api.request.*;
import com.bws.authservice.api.response.AuthUserResponse;
import com.bws.authservice.api.response.BaseResponse;
import com.bws.authservice.exceptions.PasswordNotMatchedException;
import com.bws.authservice.exceptions.UserNotActiveException;
import com.bws.authservice.model.constants.PropertyConstants;
import com.bws.authservice.rest.controller.api.AuthRestServiceApi;
import com.bws.authservice.rest.service.AuthServiceImpl;
import com.bws.authservice.rest.service.PasswordServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = PropertyConstants.REQUEST_SERVICE_AUTH_CONTROLLER)
@RequiredArgsConstructor
@CrossOrigin

public class AuthServiceController implements AuthRestServiceApi {

    private final AuthServiceImpl authService;

    private final PasswordServiceImpl passwordService;

    @Override
    public ResponseEntity<AuthUserResponse> authUser(AuthUserRequest authUserRequest, HttpServletRequest request , BindingResult bindingResult) throws UserNotActiveException {
        return ResponseEntity.ok(authService.authUser(authUserRequest));
    }

    @Override
    public ResponseEntity<BaseResponse> registerUser(UserAddRequest userAddRequest, HttpServletRequest request,BindingResult bindingResult) {
        return ResponseEntity.ok(authService.createUser(userAddRequest));
    }

    @Override
    public ResponseEntity<BaseResponse> logoutUser(BaseRequest baseRequest, HttpServletRequest request) {
        return ResponseEntity.ok(authService.logoutUser(baseRequest));
    }

    @Override
    public ResponseEntity<BaseResponse> registerSeller(SellerAddRequest sellerAddRequest, HttpServletRequest request) {
        return ResponseEntity.ok(authService.registerSeller(sellerAddRequest));
    }

    @Override
    public ResponseEntity<BaseResponse> changePassword(PasswordChangeRequest passwordChangeRequest, HttpServletRequest request)throws PasswordNotMatchedException {
        return ResponseEntity.ok(passwordService.changePassword(passwordChangeRequest));
    }

    @Override
    public ResponseEntity<BaseResponse> forgetPassword(ForgetPasswordRequest forgetPasswordRequest, HttpServletRequest request) {
        return ResponseEntity.ok(passwordService.forgetPassword(forgetPasswordRequest));
    }

    @Override
    public ResponseEntity<BaseResponse> changePwByCode(ChangePwByCodeRequest changePwByCodeRequest, HttpServletRequest request) {
        return ResponseEntity.ok(passwordService.changePwByCode(changePwByCodeRequest));
    }
}
