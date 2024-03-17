package com.example.PaidParkingOmSUServer.controller;

import com.example.PaidParkingOmSUServer.entity.UserEntity;
import com.example.PaidParkingOmSUServer.exception.UserAlreadyExistsException;
import com.example.PaidParkingOmSUServer.exception.UserNotFoundException;
import com.example.PaidParkingOmSUServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user){
        try {
            userService.registration(user);
            return ResponseEntity.ok("Пользователь успешно сохранен!");
        }catch (UserAlreadyExistsException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getUserById(@RequestParam Long id){
        try {
            return ResponseEntity.ok(userService.getUserById(id));
        }catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.deleteUser(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
