package com.example.PaidParkingOmSUServer.service;

import com.example.PaidParkingOmSUServer.entity.BuildingEntity;
import com.example.PaidParkingOmSUServer.exception.BuildingNotFoundException;
import com.example.PaidParkingOmSUServer.exception.BuildingWithSameAddressAlreadyExistsException;
import com.example.PaidParkingOmSUServer.repository.BuildingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class BuildingService {
    @Autowired
    private BuildingRepo buildingRepo;

    public BuildingEntity addBuilding(BuildingEntity building) throws BuildingWithSameAddressAlreadyExistsException {
        if (buildingRepo.findByAddress(building.getAddress())!=null){
            throw new BuildingWithSameAddressAlreadyExistsException("Здание с таким адрессом уже существует!");
        }
        return buildingRepo.save(building);
    }

    public BuildingEntity getBuildingById(@RequestParam Long id) throws BuildingNotFoundException {
        Optional<BuildingEntity> building = buildingRepo.findById(id);
        if(building.isEmpty()){
            throw new BuildingNotFoundException("Здание не найдено!");
        }
        return building.get();

    }

    public Long deleteBuilding(Long id){
        buildingRepo.deleteById(id);
        return id;
    }
}
