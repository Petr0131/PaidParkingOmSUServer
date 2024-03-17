package com.example.PaidParkingOmSUServer.service;

import com.example.PaidParkingOmSUServer.entity.BuildingEntity;
import com.example.PaidParkingOmSUServer.entity.OrderEntity;
import com.example.PaidParkingOmSUServer.entity.UserEntity;
import com.example.PaidParkingOmSUServer.exception.BuildingNotFoundException;
import com.example.PaidParkingOmSUServer.exception.OrderNotFoundException;
import com.example.PaidParkingOmSUServer.exception.UserNotFoundException;
import com.example.PaidParkingOmSUServer.repository.BuildingRepo;
import com.example.PaidParkingOmSUServer.repository.OrderRepo;
import com.example.PaidParkingOmSUServer.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BuildingRepo buildingRepo;

    public OrderEntity addOrder(OrderEntity order, Long userId, Long buildingId) throws UserNotFoundException, BuildingNotFoundException {
        Optional<UserEntity> user = userRepo.findById(userId);
        if(user.isEmpty()){
            throw new UserNotFoundException("Пользователь не найден!");
        }
        Optional<BuildingEntity> building = buildingRepo.findById(buildingId);
        if(building.isEmpty()){
            throw new BuildingNotFoundException("Здание не найдено!");
        }
        order.setUser(user.get());
        order.setBuilding(building.get());
        return orderRepo.save(order);
    }

    public OrderEntity editOrder(Long id) {
        OrderEntity order = orderRepo.findById(id).get();
        order.setStatePayment(!order.getStatePayment());
        return  orderRepo.save(order);
    }

    public OrderEntity getOrderById(Long id) throws OrderNotFoundException {
        Optional<OrderEntity> order = orderRepo.findById(id);
        if(order.isEmpty()){
            throw new OrderNotFoundException("Заказ не найден!");
        }
        return order.get();
    }

    public Long deleteOrder(Long id){
        orderRepo.deleteById(id);
        return id;
    }
}
