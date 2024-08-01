package com.bws.authservice.api.client;

import com.bws.authservice.api.request.*;
import com.bws.authservice.api.response.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "UserService" , url = "${client.feign.user-service.path}")
public interface UserServiceClient {

    @PostMapping("${client.feign.token-service.extractUsername}")
    String extractedUsername (@RequestBody BaseRequest baseRequest);

    @PostMapping("${client.feign.user-service.registerUser}")
    BaseResponse registerUser (@RequestBody UserAddRequest userAddRequest);

    @PostMapping("${client.feign.user-service.passwordChange}")
    BaseResponse changePassword (@RequestBody PasswordChangeRequest passwordChangeRequest);

    @PostMapping("${client.feign.user-service.registerSeller}")
    BaseResponse registerSeller (@RequestBody SellerAddRequest sellerAddRequest);

    @PostMapping("${client.feign.user-service.passwordForget}")
    BaseResponse forgetPassword (@RequestBody ForgetPasswordRequest forgetPasswordRequest);

    @PostMapping("${client.feign.user-service.passwordChangeWithCode}")
    BaseResponse changePwByCode (@RequestBody ChangePwByCodeRequest changePwByCodeRequest);

}
