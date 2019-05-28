package com.meru.client.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.meru.client.MeruEurekaClient;
import com.meru.client.dto.ProductDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service("productService")
public class MeruClientProductService {
	
	@Autowired
	MeruEurekaClient meruEurekaClient;
	
	@Autowired
	RestTemplate restTemplate;
	
	String appName = "http://product-service";
	String apiGateway = "http://api-gateway/api/productapp";
	String baseUrl = null;
	
	//To be used without Ribbon
	private String getBaseUrl() {
		if(baseUrl == null || baseUrl == "") {
			baseUrl = meruEurekaClient.buildGatewayRestTemplate();//with Eureka and Zuul
			//baseUrl = meruEurekaClient.buildEurekaRestTemplate("product-service"); //with Eureka alone
		}
		
		return baseUrl;
	}
	
	//@HystrixCommand(fallbackMethod="defaultFallbackMethod")
	public String message() {
		return restTemplate.getForObject(apiGateway+"/product/msg", String.class);
	}
	
	public String defaultFallbackMethod() {
		return "Service temporarily unavailable!!!";
	}
	
	public ResponseEntity<?> addProduct(ProductDto productDto) {
		return restTemplate.postForEntity(apiGateway+"/product", (Object) productDto, Object.class);
		
	}
	
	public ResponseEntity<?> getAllProducts() {
		return restTemplate.getForEntity(apiGateway+"/product", Object.class);
	}
	
	public ResponseEntity<?> getProductById(Integer id) {
		return restTemplate.getForEntity(apiGateway+"/product/{id}", Object.class, id);
	}
	
	public ResponseEntity<?> updateProduct(ProductDto productDto) {
		 restTemplate.put(apiGateway+"/product", (Object) productDto);
		 return restTemplate.getForEntity(apiGateway+"/product/{id}", Object.class, productDto.getId());
	}
	
	public ResponseEntity<?> getProductByName(String name) {
		return restTemplate.getForEntity(apiGateway+"/product/name/{name}", Object.class, name);
		
	}
	
	public ResponseEntity<?> getProductByCategory(String category) {
		return restTemplate.getForEntity(apiGateway+"/product/category/{category}", Object.class, category);
		
	}
	
	public ResponseEntity<?> removeProduct(Integer id){
		 restTemplate.delete(apiGateway+"/product/{id}", id);
		 return new ResponseEntity<Object>("Product Successfully deleted", HttpStatus.OK);
	}

}
