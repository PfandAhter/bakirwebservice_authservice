package com.bws.authservice.api.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class AuthUserResponse {

    private String token;

}
