package com.replaceMe.propertyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.RepMe.Auth", "com.replaceMe.propertyservice"})
public class PropertyServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(PropertyServiceApplication.class, args);
	}

}
