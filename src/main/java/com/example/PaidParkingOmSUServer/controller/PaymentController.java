package com.example.PaidParkingOmSUServer.controller;

import com.example.PaidParkingOmSUServer.entity.PaymentEntity;
import com.example.PaidParkingOmSUServer.exception.PaymentNotFoundException;
import com.example.PaidParkingOmSUServer.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity addPayment(@RequestBody PaymentEntity payment,
                                     @RequestParam Long userId,
                                     @RequestParam Long orderId){
        try {
            paymentService.addPayment(payment, userId, orderId);
            return ResponseEntity.ok("Платёж добавлен!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity editPayment(@RequestParam Long id, @RequestParam String bankName){
        try {
            return  ResponseEntity.ok(paymentService.editPayment(id, bankName));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getPaymentById(@RequestParam Long id){
        try {
            return ResponseEntity.ok(paymentService.getPaymentById(id));
        }catch (PaymentNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePayment(@PathVariable Long id){
        try {
            return ResponseEntity.ok(paymentService.deletePayment(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
