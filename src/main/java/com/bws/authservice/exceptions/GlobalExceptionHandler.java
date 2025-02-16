package com.bws.authservice.exceptions;

import com.bws.authservice.api.response.BaseResponse;
import com.bws.authservice.model.constants.Constants;
import com.bws.authservice.model.constants.ErrorCodeConstants;
import feign.FeignException;
import feign.RetryableException;
import jakarta.security.auth.message.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;

import static com.bws.authservice.model.constants.Constants.FAILED;

@RestControllerAdvice
@Slf4j

public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<BaseResponse> handleException(RuntimeException e) {
        log.error("Error: " + e);
        return ResponseEntity.internalServerError().body(createFailResponse(e.getMessage().split("HataMesaji")[1].substring(3,e.getMessage().split("HataMesaji")[1].length()-3)));
//TODO DURUMA GORE DIGERLERINEDE BU SPLIT LIYI EKLE ...
    }

    @ExceptionHandler(jakarta.security.auth.message.AuthException.class)
    public ResponseEntity<BaseResponse> handleException(AuthException e) {
        return ResponseEntity.badRequest().body(createFailResponse(e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse> handleException(Exception e) {
        return ResponseEntity.badRequest().body(createFailResponse(e.getMessage()));
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<BaseResponse> handleException(FeignException e){
        return ResponseEntity.badRequest().body(createFailResponse("ACCESS DENIED"));
    }

    @ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<BaseResponse> handleException(ResourceAccessException e){
        return ResponseEntity.badRequest().body(createFailResponse(ErrorCodeConstants.SERVICE_UNAVAILABLE));
    }

    @ExceptionHandler(RetryableException.class)
    public ResponseEntity<BaseResponse> handleException(RetryableException e){
        return ResponseEntity.badRequest().body(createFailResponse(ErrorCodeConstants.SERVICE_UNAVAILABLE));
    }

    private BaseResponse createFailResponse(String message) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus("0");
        baseResponse.setErrorCode(Constants.FAILED);
        baseResponse.setErrorDescription(message);
        return baseResponse;
    }
}

