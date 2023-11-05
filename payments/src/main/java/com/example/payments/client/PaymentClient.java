package com.example.payments.client;

import com.example.payments.payment.model.Payment;
import org.springframework.stereotype.Service;

@Service

public class PaymentClient {


    public Boolean createPayment(Payment payment){
        //este servicio ejecuta una llamada a un servicio externo para crear el pago

        return true;
    }
}
