package com.meru.product.service;

import java.util.List;
import com.meru.product.dto.ProductDto;

public interface ProductService {
	
	public ProductDto getProductById(Integer id);
	
	public List<ProductDto> getProducts();
	
	public List<ProductDto> getProductByName(String name);
	
	public List<ProductDto> getProductbyCategory(String category);
	
	public ProductDto addProduct(ProductDto porduct);
	
	public void removeProduct(Integer id);
	
	public ProductDto updateProduct(ProductDto product);
	
	public ProductDto doesExists(ProductDto productDto);
	
}
