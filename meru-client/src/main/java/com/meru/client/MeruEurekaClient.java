package com.meru.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@Component("meruEurekaClient")
public class MeruEurekaClient {
	
	@Autowired
	private EurekaClient eurekaClient;
	
	String apiGateway = "api-gateway";
	
	public String buildEurekaRestTemplate(String appName) {
		InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka(appName, false);
		String baseUrl = instanceInfo.getHomePageUrl();
		return baseUrl;
	}
	
	public String buildGatewayRestTemplate() {
		InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("api-gateway", false);
		String baseUrl = instanceInfo.getHomePageUrl();
		return baseUrl+"/api";
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
