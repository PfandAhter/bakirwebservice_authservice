package com.bws.authservice.api.client;

import com.bws.authservice.api.request.AuthUserRequest;
import com.bws.authservice.api.request.BaseRequest;
import com.bws.authservice.api.response.AuthUserResponse;
import com.bws.authservice.api.response.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "TokenService" , url = "${client.feign.token-service.path}")
public interface TokenServiceClient {

    @PostMapping("${client.feign.token-service.extractUsername}")
    String extractedUsername (@RequestBody BaseRequest baseRequest);

    @PostMapping("${client.feign.token-service.generateToken}")
    AuthUserResponse generateToken (@RequestBody AuthUserRequest authUserRequest);

    @PostMapping("${client.feign.token-service.logoutUser}")
    BaseResponse logoutUser (@RequestBody BaseRequest baseRequest);

}

