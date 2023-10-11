package com.example.picks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FlixApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlixApiGatewayApplication.class, args);
	}

}
