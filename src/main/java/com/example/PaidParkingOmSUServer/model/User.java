package com.example.PaidParkingOmSUServer.model;

import com.example.PaidParkingOmSUServer.entity.UserEntity;

public class User {
    private Long id;
    private String name;
    private String surName;
    private Long phoneNumber;
    private String autoNumber;

    public static User toModel(UserEntity entity){
        User model = new User();
        model.setIdUser(entity.getIdUser());
        model.setName(entity.getName());
        model.setSurName(entity.getSurName());
        model.setPhoneNumber(entity.getPhoneNumber());
        model.setAutoNumber(entity.getAutoNumber());
        return model;
    }

    public Long getIdUser() {
        return id;
    }

    public void setIdUser(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAutoNumber() {
        return autoNumber;
    }

    public void setAutoNumber(String autoNumber) {
        this.autoNumber = autoNumber;
    }
}
