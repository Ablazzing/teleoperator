package com.javaacademy.teleoperator;

import com.javaacademy.teleoperator.service.ClientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TeleoperatorApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TeleoperatorApplication.class, args);
		ClientService clientService = context.getBean(ClientService.class);
		clientService.findAll(0, 10);


	}
}
