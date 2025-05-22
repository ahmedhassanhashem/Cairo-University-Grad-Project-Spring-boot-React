package com.interna.gatewayservice.base.exception;

public class NoResourceExistException extends RuntimeException{
    public NoResourceExistException(String message) {
        super(message);
    }
}
