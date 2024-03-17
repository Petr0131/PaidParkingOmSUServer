package com.example.PaidParkingOmSUServer.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surName;
    private Long phoneNumber;
    private String autoNumber;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<OrderEntity> orders;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<PaymentEntity> payments;

    private enum Role{USER, ADMINISTRATOR};

    public long getIdUser() {
        return id;
    }

    public void setIdUser(long id) {
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

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAutoNumber() {
        return autoNumber;
    }

    public void setAutoNumber(String autoNumber) {
        this.autoNumber = autoNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
