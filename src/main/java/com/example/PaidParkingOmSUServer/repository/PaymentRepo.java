package com.example.PaidParkingOmSUServer.repository;

import com.example.PaidParkingOmSUServer.entity.PaymentEntity;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepo extends CrudRepository<PaymentEntity, Long> {

}
