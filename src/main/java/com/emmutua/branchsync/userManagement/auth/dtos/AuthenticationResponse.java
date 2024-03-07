package com.emmutua.branchsync.userManagement.auth.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationResponse {
    private String generatedToken;
    private String creationMessage;
    private boolean error;
    private String errorMessage;

    public AuthenticationResponse(String generatedToken, String creationMessage, boolean error, String errorMessage) {
        this.generatedToken = generatedToken;
        this.creationMessage = creationMessage;
        this.error = error;
        this.errorMessage = errorMessage;
    }

    public static AuthenticationResponse success(String generatedToken, String creationMessage){
        return new AuthenticationResponse(generatedToken, creationMessage, false, null);
    }
    public static AuthenticationResponse error(String errorMessage){
        return new AuthenticationResponse(null, null, true, errorMessage);
    }
}
