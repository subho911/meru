package com.meru.priceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PriceserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PriceserviceApplication.class, args);
	}

}
