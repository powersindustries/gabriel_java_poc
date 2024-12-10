package com.powersindustries.gabriel;

import com.powersindustries.gabriel.service.EmailSendingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class GabrielApplication {

	public static void main(String[] args) {
		SpringApplication.run(GabrielApplication.class, args);

		System.out.println("Gabriel - Hello world!");
	}

}
