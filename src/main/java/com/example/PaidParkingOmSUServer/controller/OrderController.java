package com.example.PaidParkingOmSUServer.controller;

import com.example.PaidParkingOmSUServer.entity.OrderEntity;
import com.example.PaidParkingOmSUServer.exception.OrderNotFoundException;
import com.example.PaidParkingOmSUServer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity addOrder(@RequestBody OrderEntity order,
                                      @RequestParam Long userId,
                                      @RequestParam Long buildingId){
        try {
            return  ResponseEntity.ok(orderService.addOrder(order, userId, buildingId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping
    public ResponseEntity editOrder(@RequestParam Long id){
        try {
            return  ResponseEntity.ok(orderService.editOrder(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getOrderById(@RequestParam Long id){
        try {
            return  ResponseEntity.ok(orderService.getOrderById(id));
        }catch (OrderNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrder(@PathVariable Long id){
        try {
            return ResponseEntity.ok(orderService.deleteOrder(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
