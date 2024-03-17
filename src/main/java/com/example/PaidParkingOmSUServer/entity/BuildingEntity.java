package com.example.PaidParkingOmSUServer.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "building")
public class BuildingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private int parkingPlaces;
    private int freeParkingPlaces;
    private int costPerHour;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "building")
    private List<OrderEntity> orders;

    public long getIdBuilding() {
        return id;
    }

    public void setIdBuilding(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getParkingPlaces() {
        return parkingPlaces;
    }

    public void setParkingPlaces(int parkingPlaces) {
        this.parkingPlaces = parkingPlaces;
    }

    public int getFreeParkingPlaces() {
        return freeParkingPlaces;
    }

    public void setFreeParkingPlaces(int freeParkingPlaces) {
        this.freeParkingPlaces = freeParkingPlaces;
    }

    public int getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(int costPerHour) {
        this.costPerHour = costPerHour;
    }
}
