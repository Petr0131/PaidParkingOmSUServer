package com.example.PaidParkingOmSUServer.repository;

import com.example.PaidParkingOmSUServer.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByPhoneNumber(Long phoneNumber);
}
