package com.example.notifications;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotificationsApplication {
// este servicio consume del topico de payments y envia al usuario una notificacion

	public static void main(String[] args) {
		SpringApplication.run(NotificationsApplication.class, args);
	}

}
