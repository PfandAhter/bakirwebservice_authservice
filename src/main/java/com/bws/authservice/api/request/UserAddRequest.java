package com.bws.authservice.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAddRequest {
    private String username;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String address;

    private String phone;

    private String district;

    private String cityName;

    private String postalCode;

    private String countryName;
}
