package com.example.PaidParkingOmSUServer.service;

import com.example.PaidParkingOmSUServer.entity.UserEntity;
import com.example.PaidParkingOmSUServer.exception.UserAlreadyExistsException;
import com.example.PaidParkingOmSUServer.exception.UserNotFoundException;
import com.example.PaidParkingOmSUServer.model.User;
import com.example.PaidParkingOmSUServer.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistsException {
        if (userRepo.findByPhoneNumber(user.getPhoneNumber())!=null){
            throw new UserAlreadyExistsException("Пользователь с таким номером телефона уже существует!");
        }
        return userRepo.save(user);
    }

    public User getUserById(@RequestParam Long id) throws UserNotFoundException {
        Optional<UserEntity> user = userRepo.findById(id);
        if (user.isEmpty()){
            throw new UserNotFoundException("Пользователь не найден!");
        }
        return User.toModel(user.get());
    }

    public Long deleteUser(Long id){
        userRepo.deleteById(id);
        return id;
    }
}
