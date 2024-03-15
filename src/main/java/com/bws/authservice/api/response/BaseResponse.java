package com.bws.authservice.api.response;

import com.bws.authservice.model.constants.Constants;
import com.bws.authservice.model.constants.ResponseStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonPropertyOrder({
        "Statu",
        "HataKodu",
        "HataMesaji"
})
public class BaseResponse {
    @JsonProperty("Statu")
    private String status = ResponseStatus.SUCCESS;

    @JsonProperty("HataKodu")
    private String errorCode = Constants.SUCCESS;

    @JsonProperty("HataMesaji")
    private String errorDescription = Constants.SUCCESS;
}