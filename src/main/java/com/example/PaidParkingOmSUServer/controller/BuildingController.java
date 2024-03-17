package com.example.PaidParkingOmSUServer.controller;

import com.example.PaidParkingOmSUServer.entity.BuildingEntity;
import com.example.PaidParkingOmSUServer.exception.BuildingNotFoundException;
import com.example.PaidParkingOmSUServer.exception.BuildingWithSameAddressAlreadyExistsException;
import com.example.PaidParkingOmSUServer.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/building")
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    @PostMapping
    public ResponseEntity addBuilding(@RequestBody BuildingEntity building){
        try {
            buildingService.addBuilding(building);
            return ResponseEntity.ok("Здание успешно сохранено!");
        }catch (BuildingWithSameAddressAlreadyExistsException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getBuilderById(@RequestParam Long id){
        try {
            return ResponseEntity.ok(buildingService.getBuildingById(id));
        }catch (BuildingNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBuilder(@PathVariable Long id){
        try {
            return ResponseEntity.ok(buildingService.deleteBuilding(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
