package com.example.payments.payment.service;

import com.example.payments.client.PaymentClient;
import com.example.payments.payment.model.Payment;
import com.example.payments.payment.notification.PublishNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService  implements IServicePayment{

    @Autowired
    private PublishNotification publishNotification;
    @Autowired
    private PaymentClient paymentClient;



    public void makePayment(Payment payment){
        paymentClient.createPayment(payment);

        publishNotification.sendMessageToTopin(payment.getClientId());

    }
}
