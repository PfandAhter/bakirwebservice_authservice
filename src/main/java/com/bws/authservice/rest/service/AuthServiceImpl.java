package com.bws.authservice.rest.service;

import com.bws.authservice.api.request.AuthUserRequest;
import com.bws.authservice.api.request.UserAddRequest;
import com.bws.authservice.api.response.AuthUserResponse;
import com.bws.authservice.api.response.BaseResponse;
import com.bws.authservice.rest.service.interfaces.IAuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.bws.authservice.model.constants.PropertyConstants.REST_TEMPLATE_REQUEST_MICROSERVICE_TOKEN_SERVICE_TOKEN_GENERATE;
import static com.bws.authservice.model.constants.PropertyConstants.REST_TEMPLATE_REQUEST_MICROSERVICE_USER_SERVICE_USER_REGISTER;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements IAuthService {
    private final RestTemplate restTemplate;

    private final AuthenticationManager authenticationManager;

    @Value(REST_TEMPLATE_REQUEST_MICROSERVICE_USER_SERVICE_USER_REGISTER)
    private String registerUserFromUserServicePaths;

    @Override
    public BaseResponse createUser(UserAddRequest request) {
        return restTemplate.postForObject(registerUserFromUserServicePaths,request,BaseResponse.class);
    }

    @Value(REST_TEMPLATE_REQUEST_MICROSERVICE_TOKEN_SERVICE_TOKEN_GENERATE)
    private String generateTokenFromTokenServicePaths;

    @Override
    public AuthUserResponse authUser(AuthUserRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword())
        );
        AuthUserResponse response = restTemplate.postForObject(generateTokenFromTokenServicePaths,request,AuthUserResponse.class);

        return AuthUserResponse.builder()
                .token(response.getToken())
                .build();
    }
}
