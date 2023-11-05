package com.example.notifications.service;



import org.slf4j.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {
    Logger logger = LoggerFactory.getLogger(NotificationConsumer.class);

    @RabbitListener(queues = "send-notification")
    public void  consume(String mesagge){
        logger.info("recibiendo mensaje del topico send-notification" + mesagge);

    }
}
