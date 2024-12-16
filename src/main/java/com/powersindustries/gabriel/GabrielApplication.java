package com.powersindustries.gabriel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GabrielApplication {

	public static void main(String[] args) {
		SpringApplication.run(GabrielApplication.class, args);

		System.out.println("Gabriel - Hello world!");
	}

}
