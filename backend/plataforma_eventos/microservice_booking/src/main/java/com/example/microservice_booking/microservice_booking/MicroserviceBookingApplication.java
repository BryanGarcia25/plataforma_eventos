package com.example.microservice_booking.microservice_booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceBookingApplication.class, args);
	}

}
