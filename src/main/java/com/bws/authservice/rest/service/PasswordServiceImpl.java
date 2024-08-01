package com.bws.authservice.rest.service;

import com.bws.authservice.api.client.TokenServiceClient;
import com.bws.authservice.api.client.UserServiceClient;
import com.bws.authservice.api.request.ChangePwByCodeRequest;
import com.bws.authservice.api.request.ForgetPasswordRequest;
import com.bws.authservice.api.request.PasswordChangeRequest;
import com.bws.authservice.api.response.BaseResponse;
import com.bws.authservice.exceptions.PasswordNotMatchedException;
import com.bws.authservice.rest.service.interfaces.IPasswordService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
@RequiredArgsConstructor
@Slf4j

public class PasswordServiceImpl implements IPasswordService {

    private final UserServiceClient userServiceClient;

    private final TokenServiceClient tokenServiceClient;

    private final AuthenticationManager authenticationManager;

    @Override
    public BaseResponse changePassword (PasswordChangeRequest request) throws PasswordNotMatchedException {

        String localUsername = tokenServiceClient.extractedUsername(request);
        if(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(localUsername,request.getOldPassword())).isAuthenticated()){
            userServiceClient.changePassword(request);

            return new BaseResponse();
        }else if (!request.getNewPassword().equals(request.getNewPasswordAgain())){
            throw new PasswordNotMatchedException("PASSWORD NOT MATCHED.");
        }else{
            throw new PasswordNotMatchedException("OLD PASSWORD NOT CORRECT");
        }
    }


    @Override
    public BaseResponse forgetPassword (ForgetPasswordRequest request){
        return userServiceClient.forgetPassword(request);
    }

    @Override
    public BaseResponse changePwByCode (ChangePwByCodeRequest request){
        return userServiceClient.changePwByCode(request);
    }


}
