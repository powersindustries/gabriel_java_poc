package com.powersindustries.gabriel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GabrielApplication {

	public static void main(String[] args) {
		System.out.println("Gabriel - Hello world!");

		SpringApplication.run(GabrielApplication.class, args);
	}

}
