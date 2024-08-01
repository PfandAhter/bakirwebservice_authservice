package com.bws.authservice.rest.service;

import com.bws.authservice.api.client.TokenServiceClient;
import com.bws.authservice.api.client.UserServiceClient;
import com.bws.authservice.api.request.*;
import com.bws.authservice.api.response.AuthUserResponse;
import com.bws.authservice.api.response.BaseResponse;
import com.bws.authservice.exceptions.PasswordNotMatchedException;
import com.bws.authservice.exceptions.UserNotActiveException;
import com.bws.authservice.model.entity.User;
import com.bws.authservice.repository.UserRepository;
import com.bws.authservice.rest.service.interfaces.IAuthService;
import com.bws.authservice.rest.service.interfaces.IPasswordService;
import com.bws.authservice.rest.util.Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements IAuthService  {

    private final AuthenticationManager authenticationManager;

    private final TokenServiceClient tokenServiceClient;

    private final UserRepository userRepository;

    private final UserServiceClient userServiceClient;

    @Override
    public BaseResponse createUser(UserAddRequest request) {
        return userServiceClient.registerUser(request);
    }

    @Override
    public AuthUserResponse authUser(AuthUserRequest request) throws UserNotActiveException{
        //int coreCount = Runtime.getRuntime().availableProcessors();

        User user = userRepository.findByUsername(request.getUsername());

        if(user.getActive() == 1) {

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );

            AuthUserResponse response = tokenServiceClient.generateToken(request);

            return AuthUserResponse.builder()
                    .token(response.getToken())
                    .role(user.getRole())
                    .build();
        }else{
            throw new UserNotActiveException("USER NOT ACTIVE \nCHECK EMAIL VERIFICATION \nCHECK USER NOT ACTIVE");
        }

    }

    @Override
    public BaseResponse logoutUser (BaseRequest baseRequest) {
        return tokenServiceClient.logoutUser(baseRequest);
    }

    public BaseResponse registerSeller (SellerAddRequest request){
        return userServiceClient.registerSeller(request);
    }

}
