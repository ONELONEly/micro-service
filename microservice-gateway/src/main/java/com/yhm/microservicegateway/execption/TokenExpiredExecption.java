package com.yhm.microservicegateway.execption;

public class TokenExpiredExecption extends RuntimeException {

    public TokenExpiredExecption(String message) {
        super(message);
    }
}
