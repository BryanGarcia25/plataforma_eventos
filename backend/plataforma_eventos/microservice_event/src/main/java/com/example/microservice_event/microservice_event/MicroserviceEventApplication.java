package com.example.microservice_event.microservice_event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceEventApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceEventApplication.class, args);
	}

}
