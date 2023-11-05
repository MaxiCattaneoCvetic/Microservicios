package com.example.payments.payment.controller;

import com.example.payments.payment.model.Payment;
import com.example.payments.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;




    @PostMapping()
    public void CreatePayment(@RequestBody Payment payment){
        paymentService.makePayment(payment);


    }

}
