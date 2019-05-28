package com.meru.clientservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.meru.clientservice.entity.Price;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class PriceClientController {
	
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	RestTemplate restTemplate;
	
	//Ribbon and Hystrix through Eureka
	@RequestMapping("/client/ribbon/price")
	@HystrixCommand(fallbackMethod = "fallback_getAllPrice")
	public List<Price> getAllPrice() {
		ResponseEntity<List<Price>> response = restTemplate.exchange("http://price-service/price", HttpMethod.GET,
				  null,
				  new ParameterizedTypeReference<List<Price>>(){});
		List<Price> price = response.getBody();
		return price;
	}

	
	public String fallback_getAllPrice() {
		return "Service unavilable. Hello from Hystrix fallback method";
	}
}
