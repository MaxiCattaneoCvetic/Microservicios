package com.example.payments.payment.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/payments")
@RestController()
public class PaymentController {
    @Autowired
    private PaymentService paymentService;




    @PostMapping()
    public void CreatePayment(@RequestBody Payment payment){
        paymentService.makePayment(payment);


    }

}
