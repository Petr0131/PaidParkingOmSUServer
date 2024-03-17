package com.example.PaidParkingOmSUServer.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bankName;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToOne
    @JoinColumn(name = "orders_id")
    private OrderEntity order;

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public long getIdPayment() {
        return id;
    }

    public void setIdPayment(long id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
