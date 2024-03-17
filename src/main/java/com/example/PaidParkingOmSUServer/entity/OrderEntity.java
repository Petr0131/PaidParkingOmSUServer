package com.example.PaidParkingOmSUServer.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean statePayment;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private BuildingEntity building;

    @OneToOne
    private PaymentEntity payment;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public BuildingEntity getBuilding() {
        return building;
    }

    public void setBuilding(BuildingEntity building) {
        this.building = building;
    }

    public long getIdOrder() {
        return id;
    }

    public void setIdOrder(long id) {
        this.id = id;
    }

    public boolean getStatePayment() {
        return statePayment;
    }

    public void setStatePayment(boolean statePayment) {
        this.statePayment = statePayment;
    }
}
