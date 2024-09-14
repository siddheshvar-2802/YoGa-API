package com.yoga.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class YoGaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(YoGaApiApplication.class, args);
		System.out.println("Yoga application is running...");
	}

}
