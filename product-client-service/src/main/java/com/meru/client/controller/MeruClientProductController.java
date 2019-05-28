package com.meru.client.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.meru.client.dto.ProductDto;
import com.meru.client.service.MeruClientProductService;

@RestController
@RequestMapping("/product")
public class MeruClientProductController {
	
		@Autowired
		MeruClientProductService productService;
		
		@RequestMapping(method=RequestMethod.GET, value="/msg")
		public String message() {
			return productService.message();
		}
		
		@RequestMapping(method=RequestMethod.POST)
		public ResponseEntity<?> addProduct(@Valid @RequestBody ProductDto productDto, BindingResult result) {
			return productService.addProduct(productDto);
		}
		
		@RequestMapping(method=RequestMethod.GET)
		public ResponseEntity<?> getAllProducts() {
			return productService.getAllProducts();
		}
		
		@RequestMapping(method=RequestMethod.GET, path="/{id}")
		public ResponseEntity<?> getProductById(@PathVariable Integer id) {
			return productService.getProductById(id);
		}
		
		@RequestMapping(method=RequestMethod.PUT)
		public ResponseEntity<?> updateProduct(@Valid @RequestBody ProductDto productDto, BindingResult result) {
			return productService.updateProduct(productDto);
		}
		
		@RequestMapping(method=RequestMethod.GET, value="/name/{name}")
		public ResponseEntity<?> getProductByName(@PathVariable String name) {
			return productService.getProductByName(name);
		}
		
		@RequestMapping(method=RequestMethod.GET, value="/category/{category}")
		public ResponseEntity<?> getProductByCategory(@PathVariable String category) {
			return productService.getProductByCategory(category);
		}
		
		@RequestMapping(method=RequestMethod.DELETE, path="/{id}")
		public ResponseEntity<?> removeProduct(@PathVariable(required=true) Integer id){
			return productService.removeProduct(id);
		}
}
