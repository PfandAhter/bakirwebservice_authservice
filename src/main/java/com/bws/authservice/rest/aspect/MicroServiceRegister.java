package com.bws.authservice.rest.aspect;

import com.bws.authservice.api.client.MicroServiceRegisterClient;
import com.bws.authservice.api.request.MicroServiceReadyRequest;
import com.bws.authservice.api.request.MicroServiceStoppedRequest;
import com.bws.authservice.rest.util.Util;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
@RequiredArgsConstructor
@Component
@Slf4j

public class MicroServiceRegister {

    private final MicroServiceRegisterClient microServiceRegisterClient;

    private String microServiceCode;

    private static final String microServiceName = "AUTH-SERVICE";


    @EventListener(ApplicationReadyEvent.class)
    public void logToDataBaseServiceReady(){
        microServiceCode = Util.generateCode();
        MicroServiceReadyRequest microServiceReadyRequest = new MicroServiceReadyRequest();
        microServiceReadyRequest.setMicroServiceCode(microServiceCode);
        microServiceReadyRequest.setMicroServiceStatus("UP");
        microServiceReadyRequest.setMicroServiceErrorCode("5000");
        microServiceReadyRequest.setMicroServiceReadyDate(Timestamp.from(Instant.now()));
        microServiceReadyRequest.setMicroServiceName(microServiceName);

        microServiceRegisterClient.microServiceReady(microServiceReadyRequest);
    }

    @PreDestroy
    public void testLogToDatabaseStopped(){
        MicroServiceStoppedRequest microServiceStoppedRequest = new MicroServiceStoppedRequest();
        microServiceStoppedRequest.setMicroServiceStoppedDate(Timestamp.from(Instant.now()));
        microServiceStoppedRequest.setMicroServiceName(microServiceName);
        microServiceStoppedRequest.setMicroServiceErrorCode("5000");
        microServiceStoppedRequest.setMicroServiceStatus("DOWN");
        microServiceStoppedRequest.setMicroServiceCode(microServiceCode);

        microServiceRegisterClient.microServiceStopped(microServiceStoppedRequest);
    }

//    @EventListener(ContextStoppedEvent.class)
//    public void logToDataBaseServiceStopped(){
//        MicroServiceStoppedRequest microServiceStoppedRequest = new MicroServiceStoppedRequest();
//        microServiceStoppedRequest.setMicroServiceStoppedDate(Timestamp.from(Instant.now()));
//        microServiceStoppedRequest.setMicroServiceName(microServiceName);
//        microServiceStoppedRequest.setMicroServiceErrorCode("5000");
//        microServiceStoppedRequest.setMicroServiceStatus("SHUTDOWN");
//        microServiceStoppedRequest.setMicroServiceCode(microServiceCode);
//
//        microServiceRegisterServiceClient.microServiceStopped(microServiceStoppedRequest);

//    }

//    @PostConstruct
//    public void startUpApplication(){
//        log.info("HELLO ");
//    }


    @EventListener(ApplicationFailedEvent.class)
    public void LogApplicationFailedException (Exception e){
        log.error("UNDER TEST KAPANMA HATASI : " + e.getMessage());
    }

}
