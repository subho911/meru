package com.meru.product.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.meru.product.dto.ProductDto;
import com.meru.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Value("${server.port}")
	String serverPort;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(method=RequestMethod.GET, value="/msg")
	public String message() {
		return "Meru Product Service from port "+serverPort;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> addProduct(@Valid @RequestBody ProductDto productDto, BindingResult result) {
		
		if(result.hasErrors()) {
			return new ResponseEntity<Object>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		
		ProductDto temp = productService.doesExists(productDto);
		if( temp.getName() != null) {
			return new ResponseEntity<Object>("Product Already Exists", HttpStatus.CONFLICT);
		}
		
		ProductDto dto  = productService.addProduct(productDto);
		
		if(dto == null) {
			return new ResponseEntity<Object>("Product Creation Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
		return new ResponseEntity<ProductDto>(dto, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<?> updateProduct(@Valid @RequestBody ProductDto productDto, BindingResult result) {
		
		if(result.hasErrors()) {
			return new ResponseEntity<Object>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		
		if(productService.doesExists(productDto) == null) {
			return new ResponseEntity<Object>("Product does not exists!!!", HttpStatus.NOT_FOUND);
		}
		
		if(productService.updateProduct(productDto) == null) {
			return new ResponseEntity<Object>("Product Update Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<ProductDto>(productDto, HttpStatus.OK);
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ProductDto>> getAllProducts() {
		
		return new ResponseEntity<List<ProductDto>>(productService.getProducts(), HttpStatus.OK);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/{id}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable Integer id) {
		
		return new ResponseEntity<ProductDto>(productService.getProductById(id), HttpStatus.OK);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/name/{name}")
	public ResponseEntity<List<ProductDto>> getProductByName(@PathVariable String name) {
		
		return new ResponseEntity<List<ProductDto>>(productService.getProductByName(name), HttpStatus.OK);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/category/{category}")
	public ResponseEntity<List<ProductDto>> getProductByCategory(@PathVariable String category) {
		
		return new ResponseEntity<List<ProductDto>>(productService.getProductbyCategory(category), HttpStatus.OK);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, path="/{id}")
	public ResponseEntity<?> removeProduct(@PathVariable(required=true) Integer id){
		
		if(productService.getProductById(id) == null) {
			return new ResponseEntity<Object>("Product does not exists!!!", HttpStatus.NOT_FOUND);
		}
		
		productService.removeProduct(id);
		
		return new ResponseEntity<Object>("Product Successfully deleted", HttpStatus.OK);
		
	}
}