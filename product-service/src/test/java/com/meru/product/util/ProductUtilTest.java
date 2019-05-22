package com.meru.product.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.meru.product.dto.ProductDto;
import com.meru.product.entity.Product;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductUtilTest {
	
	@Autowired(required=false)
	ProductUtil productUtil;

	@Test
	public void testConvertEntityToDtoProduct() {
		Product product = new Product(1,"S5", "Mobile", "Samsung Mobile");
		assertNotNull(product);
		productUtil.test();
		ProductDto dto = productUtil.convertEntityToDto(product);
		
		assertEquals(product.getName(), dto.getName());
		assertEquals(product.getCategory(), dto.getCategory());
		assertEquals(product.getDescription(), dto.getDescription());
	}

	@Test
	public void testConvertDtoToEntityProductDto() {
		ProductDto dto = new ProductDto(1,"S5", "Mobile", "Samsung Mobile");
		
		assertNotNull(dto);
		
		Product product = productUtil.convertDtoToEntity(dto);
		
		assertEquals(dto.getName(), product.getName());
		assertEquals(dto.getCategory(), product.getCategory());
		assertEquals(dto.getDescription(), product.getDescription());
	}

	@Test
	public void testConvertEntityToDtoListOfProduct() {
		
		Product p1 = new Product(1, "S6", "Mobile", "Samsung Mobile");
		Product p2 = new Product(2, "S7", "Mobile", "Samsung Mobile");
		Product p3 = new Product(3, "TitanRaga", "Watch", "Wrist Watches");
		
		List<Product> products = new ArrayList<Product>();
		products.add(p1);
		products.add(p2);
		products.add(p3);
		
		assertNotNull(products);
		assertNotEquals(0, products.size());
		
		List<ProductDto> dtos = productUtil.convertEntityToDto(products);
		
		assertEquals(products.size(), dtos.size());;
		assertEquals(products.get(1).getName(), dtos.get(1).getName());
		assertEquals(products.get(1).getCategory(), dtos.get(1).getCategory());
		assertEquals(products.get(1).getDescription(), dtos.get(1).getDescription());
		
	}

	@Test
	public void testConvertDtoToEntityListOfProductDto() {
		ProductDto p1 = new ProductDto(1, "S6", "Mobile", "Samsung Mobile");
		ProductDto p2 = new ProductDto(2, "S7", "Mobile", "Samsung Mobile");
		ProductDto p3 = new ProductDto(3, "TitanRaga", "Watch", "Wrist Watches");
		
		List<ProductDto> dtos = new ArrayList<ProductDto>();
		dtos.add(p1);
		dtos.add(p2);
		dtos.add(p3);
		
		assertNotNull(dtos);
		assertNotEquals(0, dtos.size());
		
		List<Product> products = productUtil.convertDtoToEntity(dtos);
		
		assertEquals(dtos.size(), products.size());
		assertEquals(dtos.get(1).getName(), products.get(1).getName());
		assertEquals(dtos.get(1).getCategory(), products.get(1).getCategory());
		assertEquals(dtos.get(1).getDescription(), products.get(1).getDescription());
	}

}
