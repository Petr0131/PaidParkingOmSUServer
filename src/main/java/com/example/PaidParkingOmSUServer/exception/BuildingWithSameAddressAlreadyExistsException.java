package com.example.PaidParkingOmSUServer.exception;

public class BuildingWithSameAddressAlreadyExistsException extends Exception{
    public BuildingWithSameAddressAlreadyExistsException(String message) {
        super(message);
    }
}
