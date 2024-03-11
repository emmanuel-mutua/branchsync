package com.emmutua.branchsync.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomResponse {
    private Boolean error;
    private String message;

    public CustomResponse(Boolean error, String message) {
        this.error = error;
        this.message = message;
    }

    public static CustomResponse success(String message){
        return new CustomResponse(false, message);
    }
    public static CustomResponse error(String message){
        return new CustomResponse(true, message);
    }
}
