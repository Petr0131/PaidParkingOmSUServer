package com.example.PaidParkingOmSUServer.repository;

import com.example.PaidParkingOmSUServer.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<OrderEntity, Long> {
}
