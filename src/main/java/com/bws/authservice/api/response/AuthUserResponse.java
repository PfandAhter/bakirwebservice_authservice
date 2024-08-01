package com.bws.authservice.api.response;

import com.bws.authservice.model.Role;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor

public class AuthUserResponse {

    private String token;

    private Role role;

}
