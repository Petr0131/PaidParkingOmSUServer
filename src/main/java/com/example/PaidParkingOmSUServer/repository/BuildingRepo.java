package com.example.PaidParkingOmSUServer.repository;

import com.example.PaidParkingOmSUServer.entity.BuildingEntity;
import org.springframework.data.repository.CrudRepository;

public interface BuildingRepo extends CrudRepository<BuildingEntity, Long> {
    BuildingEntity findByAddress(String address);
}
