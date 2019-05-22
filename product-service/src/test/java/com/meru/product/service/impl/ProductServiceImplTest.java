package com.meru.product.service.impl;

import static org.junit.Assert.*;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.meru.product.dao.ProductRepository;
import com.meru.product.dto.ProductDto;
import com.meru.product.entity.Product;
import com.meru.product.service.ProductService;
import com.meru.product.util.ProductUtil;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductServiceImplTest {
	
	@MockBean
	ProductRepository productRepository;
	
	@Autowired
	ProductUtil productUtil;
	
	@Autowired 
	ProductService productService;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetProductById() {
		Product product = new Product(1, "MINote3","Mobile","RedMi mobile");
				
		when(productRepository.findOne(product.getId())).thenReturn(product);
		
		ProductDto p1 = productService.getProductById(product.getId());
		
		assertEquals(product.getName(), p1.getName());
		assertEquals(product.getCategory(), p1.getCategory());
		assertEquals(product.getDescription(), p1.getDescription());
	}

	@Test
	public void testGetProducts() {
		
		Product p1 = new Product(1, "S6", "Mobile", "Samsung Mobile");
		Product p2 = new Product(2, "S7", "Mobile", "Samsung Mobile");
		Product p3 = new Product(3, "TitanRaga", "Watch", "Wrist Watches");
		Product p4 = new Product(4, "L450", "Laptop", "Lenovo Laptop");
		Product p5 = new Product(5, "S8", "Mobile", "Samsung Mobile");
		
		List<Product> products = new ArrayList<Product>();
		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);
		products.add(p5);
		
		when(productRepository.findAll()).thenReturn(products);
		
		List<ProductDto> result = productService.getProducts();
		assertEquals(products.size(), result.size());
		verify(productRepository).findAll();
	}

	@Test
	public void testGetProductByName() {
		
		Product p1 = new Product(1, "S6", "Mobile", "Samsung Mobile");
		Product p5 = new Product(5, "s6 Test", "Mobile", "Samsung Mobile");
		
		List<Product> products = new ArrayList<Product>();
		products.add(p1);
		products.add(p5);
		
		when(productRepository.findByName("s6".toUpperCase())).thenReturn(products);
		
		List<ProductDto> dtos = productService.getProductByName("s6".toUpperCase());
		
		assertEquals(products.size(), dtos.size());
		verify(productRepository).findByName("s6".toUpperCase());
	}

	@Test
	public void testGetProductbyCategory() {
		
		Product p1 = new Product(1, "S6", "Mobile", "Samsung Mobile");
		Product p2 = new Product(2, "S7", "Mobile", "Samsung Mobile");
		Product p5 = new Product(5, "S8", "Mobile", "Samsung Mobile");
		
		List<Product> products = new ArrayList<Product>();
		products.add(p1);
		products.add(p2);
		products.add(p5);
		
		when(productRepository.findByCategory("Mobile".toUpperCase())).thenReturn(products);
		
		List<ProductDto> result = productService.getProductbyCategory("Mobile".toUpperCase());
		assertEquals(products.size(), result.size());
		verify(productRepository).findByCategory("Mobile".toUpperCase());
		
	}

	@Test
	public void testAddProduct() {
		
		Product product = new Product(1, "MINote3","Mobile","RedMi mobile");
		
		when(productRepository.save(product)).thenReturn(product);
		
		ProductDto p1 = productService.addProduct(productUtil.convertEntityToDto(product));
		
		assertEquals(product.getName(), p1.getName());
		assertEquals(product.getCategory(), p1.getCategory());
		assertEquals(product.getDescription(), p1.getDescription());
		
	}

	@Test
	public void testRemoveProduct() {
		
		Product p1 = new Product("S6", "Mobile", "Samsung Mobile");
		Product p2 = new Product("S7", "Mobile", "Samsung Mobile");
		Product p3 = new Product("S8", "Mobile", "Samsung Mobile");
		
		List<Product> products = new ArrayList<Product>();
		products.add(p1);
		products.add(p2);
		
		doNothing().when(productRepository).delete(isA(Integer.class));
		productService.removeProduct(p3.getId());
		verify(productRepository, times(1)).delete(p3.getId());
	}

	@Test
	public void testUpdateProduct() {
		
		ProductDto dto = new ProductDto(1, "MINote3","Mobile","RedMi mobile");
		
		when(productRepository.updateProduct(dto.getId(), dto.getName(), 
											  dto.getCategory(), dto.getDescription())).thenReturn(1);
		
		ProductDto p1 = productService.updateProduct(dto);
		
		assertEquals(dto.getName(), p1.getName());
		assertEquals(dto.getCategory(), p1.getCategory());
		assertEquals(dto.getDescription(), p1.getDescription());
	}

}
