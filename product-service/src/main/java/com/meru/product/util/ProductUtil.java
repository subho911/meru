package com.meru.product.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.meru.product.dto.ProductDto;
import com.meru.product.entity.Product;

@Component("productUtil")
public class ProductUtil {
	
	public void test() {
		System.out.println("test");
	}
	
	public ProductDto convertEntityToDto(Product product) {
		
		ProductDto dto = new ProductDto();
		
		if(product ==  null) {
			return dto;
		}
		
		dto.setId(product.getId());
		dto.setName(product.getName());
		dto.setCategory(product.getCategory());
		dto.setDescription(product.getDescription());
		
		return dto;
	}
	
	public Product convertDtoToEntity(ProductDto productDto) {
		
		Product product = new Product();
		
		if(productDto == null) {
			return product;
		}
		
		product.setName(productDto.getName());
		product.setCategory(productDto.getCategory());
		product.setDescription(productDto.getDescription());
		
		return product;
	}
	
	public List<ProductDto> convertEntityToDto(List<Product> products) {
		
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		
		if(products == null || products.isEmpty()) {
			return productDtos;
		}
		
		for(Product product : products) {
			productDtos.add(convertEntityToDto(product));
		}
		
		return productDtos;
	}
	
	public List<Product> convertDtoToEntity(List<ProductDto> productDtos) {
		
		List<Product> products = new ArrayList<Product>();
		
		if(productDtos == null || productDtos.isEmpty()) {
			return products;
		}
		
		for(ProductDto dto : productDtos) {
			
			products.add(convertDtoToEntity(dto));
		}
		
		return products;
	}

}
