package com.example.PaidParkingOmSUServer.service;

import com.example.PaidParkingOmSUServer.entity.OrderEntity;
import com.example.PaidParkingOmSUServer.entity.PaymentEntity;
import com.example.PaidParkingOmSUServer.entity.UserEntity;
import com.example.PaidParkingOmSUServer.exception.PaymentNotFoundException;
import com.example.PaidParkingOmSUServer.exception.UserNotFoundException;
import com.example.PaidParkingOmSUServer.repository.OrderRepo;
import com.example.PaidParkingOmSUServer.repository.PaymentRepo;
import com.example.PaidParkingOmSUServer.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepo paymentRepo;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private UserRepo userRepo;


    public PaymentEntity addPayment(PaymentEntity payment, Long userId, Long orderId) throws UserNotFoundException {
        Optional<UserEntity> user = userRepo.findById(userId);
        if(user.isEmpty()){
            throw new UserNotFoundException("Пользователь не найден!");
        }
        Optional<OrderEntity> order = orderRepo.findById(orderId);
        if(order.isEmpty()){
            throw new UserNotFoundException("Заказ не найден!");
        }
        payment.setUser(user.get());
        payment.setOrder(order.get());
        return paymentRepo.save(payment);
    }

    public PaymentEntity editPayment(Long id, String bankName) throws PaymentNotFoundException {
        Optional<PaymentEntity> payment = paymentRepo.findById(id);
        if(payment.isEmpty()){
            throw new PaymentNotFoundException("Платеж не найден!");
        }
        payment.get().setBankName(bankName);
        return  paymentRepo.save(payment.get());
    }

    public PaymentEntity getPaymentById(@RequestParam Long id) throws PaymentNotFoundException {
        Optional<PaymentEntity> payment = paymentRepo.findById(id);
        if (payment.isEmpty()){
            throw new PaymentNotFoundException("Здание не найдено!");
        }
        return payment.get();
    }

    public Long deletePayment(Long id){
        orderRepo.deleteById(id);
        return id;
    }
}
