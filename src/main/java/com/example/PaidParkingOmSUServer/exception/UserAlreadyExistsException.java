package com.example.PaidParkingOmSUServer.exception;

public class UserAlreadyExistsException extends Exception{
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
