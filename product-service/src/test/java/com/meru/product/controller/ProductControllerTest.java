package com.meru.product.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.meru.product.ProductServiceApplication;
import com.meru.product.dao.ProductRepository;
import com.meru.product.dto.ProductDto;
import com.meru.product.entity.Product;
import com.meru.product.service.ProductService;
import com.meru.product.util.ProductUtil;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ProductServiceApplication.class)
@WebMvcTest
public class ProductControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	ProductService productService;
	
	@Autowired
    private WebApplicationContext wac;
	
	@Before
	public void setup() {
		this.mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void testAddProduct() {
		
		
//		 ProductDto product = new ProductDto(1,"MINote3","Mobile","RedMi mobile");
//		 
//		 String prodJson = "{\"name\":\"MINote3\",\"category\":\"Mobile\",\"description\":\"RedMi mobile\"}";
//		 
//		 //given(productService.doesExists(product)).willReturn(null);
//		 
//		 //given(productService.addProduct(product)).willReturn(product);
//		 
//		 //when(productService.doesExists(product)).thenReturn(null);
//		 
//		 //when(productService.addProduct(product)).thenReturn(product);
//		 
//		 RequestBuilder request = MockMvcRequestBuilders.post("/product")
//				 										.accept(MediaType.APPLICATION_JSON)
//				 										.content(prodJson)
//				 										.contentType(MediaType.APPLICATION_JSON);
//		 try {
////			 MockHttpServletResponse  response = mvc.perform(request).andReturn().getResponse();
////			 assertEquals(HttpStatus.CREATED, response.getStatus());
////			 assertEquals(true, response.equals(product));
//			 
//			 mvc.perform(request)
//			 	.andExpect(status().isCreated());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		 
	}

	@Test
	public void testUpdateProduct() {
		
//		ProductDto product = new ProductDto(1,"MINote3","Mobile","RedMi mobile");
//		 
//		 String prodJson = "{\"id\":1,\"name\":\"MINote3\",\"category\":\"Mobile\",\"description\":\"RedMi mobile\"}";
//		 
//		 given(productService.doesExists(product)).willReturn(null);
//		 
//		 given(productService.addProduct(product)).willReturn(product);
//		 
//		 //when(productService.doesExists(product)).thenReturn(product);
//		 
//		 //when(productService.updateProduct(product)).thenReturn(product);
//		 
//		 RequestBuilder request = MockMvcRequestBuilders.put("/product")
//				 										.accept(MediaType.APPLICATION_JSON)
//				 										.content(prodJson)
//				 										.contentType(MediaType.APPLICATION_JSON);
//		 try {
//			 //MockHttpServletResponse  response = mvc.perform(request).andReturn().getResponse();
//			//assertEquals(HttpStatus.OK, response.getStatus());
//			//assertEquals(true, response.equals(product));
//			 
//			 mvc.perform(request)
//			 .andExpect(status().isOk());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@Test
	public void testGetAllProducts() {
		
		ProductDto p1 = new ProductDto(1, "S6", "Mobile", "Samsung Mobile");
		ProductDto p2 = new ProductDto(2, "S7", "Mobile", "Samsung Mobile");
		ProductDto p3 = new ProductDto(3, "TitanRaga", "Watch", "Wrist Watches");
		ProductDto p4 = new ProductDto(4, "L450", "Laptop", "Lenovo Laptop");
		ProductDto p5 = new ProductDto(5, "S8", "Mobile", "Samsung Mobile");
		
		List<ProductDto> products = new ArrayList<ProductDto>();
		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);
		products.add(p5);
		
		given(productService.getProducts()).willReturn(products);
		
		 try {
			mvc.perform(get("/product")
			    .contentType(MediaType.APPLICATION_JSON))
			    .andExpect(status().isOk())
			    .andExpect(jsonPath("$", hasSize(5)))
			    .andExpect(jsonPath("$[0].name", is(p1.getName())))
			    .andExpect(jsonPath("$[1].name", is(p2.getName())))
			    .andExpect(jsonPath("$[2].name", is(p3.getName())))
			    .andExpect(jsonPath("$[3].name", is(p4.getName())))
			    .andExpect(jsonPath("$[4].name", is(p5.getName())));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        
	}

	@Test
	public void testGetProductById() {
		
		ProductDto p1 = new ProductDto(1,"S6", "Mobile", "Samsung Mobile");
		
		given(productService.getProductById(p1.getId())).willReturn(p1);
		
		 try {
				mvc.perform(get("/product/{id}", p1.getId())
				    .contentType(MediaType.APPLICATION_JSON))
				    .andExpect(status().isOk())
				    .andExpect(jsonPath("$.name", is(p1.getName())))
				    .andExpect(jsonPath("$.category", is(p1.getCategory())))
				    .andExpect(jsonPath("$.description", is(p1.getDescription())));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Test
	public void testGetProductByName() {
		String name = "s6";
		
		ProductDto p1 = new ProductDto(1,"S6", "Mobile", "Samsung Mobile");
		ProductDto p2 = new ProductDto(1,"s6", "Mobile", "Samsung Mobile");
		
		List<ProductDto> products = new ArrayList<ProductDto>();
		products.add(p1);
		products.add(p2);
		
		given(productService.getProductByName(name)).willReturn(products);
		
		 try {
				mvc.perform(get("/product/name/{name}", name)
				    .contentType(MediaType.APPLICATION_JSON))
				    .andExpect(status().isOk())
				    .andExpect(jsonPath("$[0].name", is(p1.getName())))
				    .andExpect(jsonPath("$[1].name", is(p2.getName())));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	}

	@Test
	public void testGetProductByCategory() {
		String category = "Mobile";
		
		ProductDto p1 = new ProductDto(1,"S6", "Mobile", "Samsung Mobile");
		ProductDto p2 = new ProductDto(1,"s6", "Mobile", "Samsung Mobile");
		
		List<ProductDto> products = new ArrayList<ProductDto>();
		products.add(p1);
		products.add(p2);
		
		given(productService.getProductbyCategory(category)).willReturn(products);
		
		 try {
				mvc.perform(get("/product/category/{category}", category)
				    .contentType(MediaType.APPLICATION_JSON))
				    .andExpect(status().isOk())
				    .andExpect(jsonPath("$[0].description", is(p1.getDescription())))
				    .andExpect(jsonPath("$[1].description", is(p2.getDescription())));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
