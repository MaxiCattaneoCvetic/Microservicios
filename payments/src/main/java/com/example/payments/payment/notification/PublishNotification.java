package com.example.payments.payment.notification;



import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishNotification  {

    //importamos el rabbbit cliente

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessageToTopin(String message) {
        //Este metodo nos permite enviar un msj a un topico, primero param nombre del topico, segundo el msj

        rabbitTemplate.convertAndSend("send-notification",message);

    }
}
