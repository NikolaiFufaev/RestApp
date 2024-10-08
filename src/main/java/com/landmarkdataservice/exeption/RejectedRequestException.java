package com.landmarkdataservice.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RejectedRequestException extends RuntimeException {
    public RejectedRequestException(String message) {
        super(message);
    }
}
